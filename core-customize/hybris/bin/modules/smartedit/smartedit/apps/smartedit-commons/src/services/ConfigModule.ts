/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as lo from 'lodash';
import { SeModule } from 'smarteditcommons/di';

/** @internal */
function $exceptionHandler($log: angular.ILogService): (exception: any, cause: any) => void {
    'ngInject';

    const ignorePatterns = [/^Possibly unhandled rejection/];

    const patternsForE2EErrorLogs = [
        /Unexpected request/, // missing http mock patterns in e2e
        /No more request expected/ // missing http mock patterns in e2e
    ];
    return function exceptionHandler(exception: any, cause: any): void {
        /*
         * original exception occuring in a promise based API won't show here
         * the catch set in decoration is necessary to log them
         */
        if (ignorePatterns.some((pattern) => pattern.test(exception))) {
            return;
        }

        if (patternsForE2EErrorLogs.some((pattern) => pattern.test(exception))) {
            $log.error(`E2E mock issue: ${exception}`);
            return;
        }

        $log.error(exception);
    };
}

function isAjaxError(error: any): boolean {
    return error.hasOwnProperty('headers');
}
/*
 * Helper function used on all known promise based Angular 1.6 APIs
 * to handle promise rejection in an AOP fashion through Angular decorators
 */
function handlePromiseRejections(
    $q: angular.IQService,
    $log: angular.ILogService,
    lodash: lo.LoDashStatic,
    promise: angular.IPromise<any>
): angular.IPromise<any> {
    const defaultFailureCallback = (error: any): angular.IPromise<never> => {
        if (undefined !== error && 'canceled' !== error) {
            if (lodash.isPlainObject(error)) {
                if (!isAjaxError(error)) {
                    $log.error(`exception caught in promise: ${JSON.stringify(error)}`);
                }
            } else if (!lodash.isBoolean(error)) {
                $log.error(error);
            }
        }
        return $q.reject(error);
    };

    const oldThen = promise.then;

    (promise.then as any) = function (
        successCallback: () => any,
        _failureCallback: () => void,
        notifyCallback: () => void
    ): angular.IPromise<any> {
        const failureCallback = _failureCallback ? _failureCallback : defaultFailureCallback;
        return oldThen.call(this, successCallback, failureCallback, notifyCallback);
    };
    return promise;
}

/** @internal */
@SeModule({
    providers: [$exceptionHandler],
    /*
     * Decoration all known promise based Angular 1.6 APIs
     * to handle promise rejection in an AOP fashion
     */
    config: ($qProvider: angular.IQProvider, $provide: angular.auto.IProvideService) => {
        'ngInject';

        $qProvider.errorOnUnhandledRejections(true);

        $provide.decorator(
            '$q',
            ($delegate: angular.IQService, $log: angular.ILogService, lodash: lo.LoDashStatic) => {
                'ngInject';

                const originalWhen = $delegate.when;
                $delegate.when = function (): angular.IPromise<any> {
                    if (arguments[0] && !arguments[0].then) {
                        return handlePromiseRejections(
                            $delegate,
                            $log,
                            lodash,
                            originalWhen.apply(this, arguments)
                        );
                    } else {
                        return originalWhen.apply(this, arguments);
                    }
                };

                const originalAll = $delegate.all;
                $delegate.all = function (): angular.IPromise<any> {
                    return handlePromiseRejections(
                        $delegate,
                        $log,
                        lodash,
                        originalAll.apply($delegate, arguments)
                    );
                };

                const originalDefer = $delegate.defer;
                $delegate.defer = function (): angular.IDeferred<any> {
                    const deferred = originalDefer.bind($delegate)();

                    handlePromiseRejections($delegate, $log, lodash, deferred.promise);

                    return deferred;
                };

                return $delegate;
            }
        );

        $provide.decorator(
            '$timeout',
            (
                $delegate: angular.ITimeoutService,
                $q: angular.IQService,
                $log: angular.ILogService,
                lodash: lo.LoDashStatic
            ) => {
                'ngInject';

                const originalTimeout = $delegate;

                function wrappedTimeout(): angular.IPromise<any> {
                    let p: angular.IPromise<any>;
                    const args = arguments;
                    if (typeof window.Zone === 'function') {
                        new window.Zone().run(() => {
                            p = handlePromiseRejections(
                                $q,
                                $log,
                                lodash,
                                originalTimeout.apply($delegate, args)
                            );
                        });
                    } else {
                        p = handlePromiseRejections(
                            $q,
                            $log,
                            lodash,
                            originalTimeout.apply($delegate, args)
                        );
                    }
                    return p;
                }

                lodash.merge(wrappedTimeout, originalTimeout);

                return wrappedTimeout;
            }
        );
    }
})
export class ConfigModule {}
