/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.jalo.promotions;

import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.promotions.jalo.AbstractPromotionAction;
import de.hybris.platform.promotions.jalo.PromotionOrderEntryConsumed;
import de.hybris.platform.promotions.jalo.PromotionResult;
import de.hybris.platform.promotions.jalo.PromotionsManager;
import de.hybris.platform.promotions.result.PromotionEvaluationContext;
import de.hybris.platform.promotions.result.PromotionOrderEntry;
import de.hybris.platform.promotions.result.PromotionOrderView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AcceleratorProductBOGOFPromotion extends GeneratedAcceleratorProductBOGOFPromotion
{
	@Override
	public List<PromotionResult> evaluate(final SessionContext ctx, final PromotionEvaluationContext promoContext)
	{
		final List<PromotionResult> results = new ArrayList<PromotionResult>();
		// Find the eligible products, and apply any restrictions
		final PromotionsManager.RestrictionSetResult restrictResult = findEligibleProductsInBasket(ctx, promoContext);
		// If the restrictions did not reject this promotion, and there are still products allowed after the restrictions
		if (restrictResult.isAllowedToContinue() && !restrictResult.getAllowedProducts().isEmpty())
		{
			final int qualifyingCount = this.getQualifyingCount(ctx).intValue();
			final int freeCount = this.getFreeCount(ctx).intValue();

			// Create a view of the order containing only the allowed products
			final PromotionOrderView orderView = promoContext.createView(ctx, this, restrictResult.getAllowedProducts());

			if (orderView.getTotalQuantity(ctx) >= qualifyingCount)
			{
				final long eligibleCountForPromotion = orderView.getTotalQuantity(ctx) / qualifyingCount;
				final long nonEligibleCount = orderView.getTotalQuantity(ctx) % qualifyingCount;
				final long totalFreeCount = freeCount * eligibleCountForPromotion;
				// Begin logging of promotions consuming order entries
				promoContext.startLoggingConsumed(this);

				// Get a price comparator
				final Comparator<PromotionOrderEntry> comparator = PromotionEvaluationContext.createPriceComparator(ctx);

				// Consume high priced items as these are the ones that will be paid for
				orderView.consumeFromTail(ctx, comparator, orderView.getTotalQuantity(ctx) - (totalFreeCount + nonEligibleCount));

				// Consume the free items from the cheap end of the list, as these result in the lowest discount
				final List<PromotionOrderEntryConsumed> freeItems = orderView.consumeFromHead(ctx, comparator, totalFreeCount);

				// Create the actions to take for this promotion to fire.  In this case an entry level discount is created
				// for each of the free items.
				final List<AbstractPromotionAction> actions = new ArrayList<AbstractPromotionAction>();
				for (final PromotionOrderEntryConsumed poec : freeItems)
				{
					// Set the adjusted unit price to zero, these are free items
					poec.setAdjustedUnitPrice(ctx, 0D);

					final double adjustment = poec.getEntryPrice(ctx) * -1.0D;

					// This action creates an order entry discount.
					actions.add(PromotionsManager.getInstance().createPromotionOrderEntryAdjustAction(ctx, poec.getOrderEntry(ctx),
							adjustment));
				}
				// Put together a the result for this iteration.
				final PromotionResult result = PromotionsManager.getInstance().createPromotionResult(ctx, this,
						promoContext.getOrder(), 1.0F);

				// Get a list of all the order entries that were consumed during this run
				final List<PromotionOrderEntryConsumed> consumed = promoContext.finishLoggingAndGetConsumed(this, true);
				result.setConsumedEntries(ctx, consumed);
				// Add the actions that this promotion has produced
				result.setActions(ctx, actions);
				// Add the result object to the list of results
				results.add(result);

			}

			// At this point the promotion cannot fire any more, so evaluate what the chances are of it firing again
			// Check to see if there are still some qualifying products in the basket
			final long remainingCount = orderView.getTotalQuantity(ctx);
			if (orderView.getTotalQuantity(ctx) > 0)
			{
				// Start logging the products we could take
				promoContext.startLoggingConsumed(this);

				// Consume the products passing false the removeFromOrder.  This means that we noted which products
				// *could* cause us to fire, but are not actually removing them from the context.
				orderView.consume(ctx, remainingCount);

				// The certainty for this is calculated as a percentage based on the qualifying items available versus
				// the number needed to make this promotion fire.
				final BigDecimal certainty = BigDecimal.valueOf(remainingCount).divide(BigDecimal.valueOf(qualifyingCount), 10,
						RoundingMode.HALF_UP);

				// Create the promotion result
				final PromotionResult result = PromotionsManager.getInstance().createPromotionResult(ctx, this,
						promoContext.getOrder(), certainty.floatValue());

				// Fill in the entries we could have consumed
				result.setConsumedEntries(promoContext.finishLoggingAndGetConsumed(this, false));

				// Add the result to the list of results
				results.add(result);
			}
		}

		return results;
	}
}
