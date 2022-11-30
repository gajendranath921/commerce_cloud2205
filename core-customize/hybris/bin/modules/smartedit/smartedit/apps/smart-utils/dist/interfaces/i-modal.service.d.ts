/**
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * @module smartutils
 */
import { ModalRef } from '@fundamental-ngx/core';
import { ModalOpenConfig } from '../services/modal';
export declare abstract class IModalService {
    /**
     * Opens a @fundamental-ngx modal.
     * Provides a simple way to open modal windows with custom content, that share a common look and feel.
     *
     * The modal window can be closed multiple ways, through Button Actions,
     * by explicitly calling the [close]{@link ModalManager#close} or [dismiss]{@link ModalManager#dismiss} functions, etc...
     *
     * Depending on how you choose to close a modal, either the modal promise's will be resolved or rejected.
     * You can use the callbacks to return data from the modal content to the caller of this function.
     *
     * @returns Promise that will be either resolved or rejected when the modal window is closed.
     */
    open<T>(conf: ModalOpenConfig<T>): ModalRef;
    hasOpenModals(): boolean;
    /**
     * Dismisses all instances of modals both produced by angular bootstrap ui and Fundamental
     */
    dismissAll(): void;
}
