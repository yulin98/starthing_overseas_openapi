package com.starthing.model.subscription;

import java.io.Serializable;

/**
 * Model for order subscription
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public final class OrderSubscriptionModel implements Serializable {

    /**
     * Callback method when server notification on order completion.
     */
    private final String notificationMethod;

    /**
     * Callback address when server notification on order completion.
     */
    private final String notificationAddress;

    /**
     * Extension payload when server notification on order completion.
     */
    private final String notificationPayload;

    public OrderSubscriptionModel(String notificationMethod, String notificationAddress, String notificationPayload) {
        this.notificationMethod = notificationMethod;
        this.notificationAddress = notificationAddress;
        this.notificationPayload = notificationPayload;
    }

    public String getNotificationMethod() {
        return notificationMethod;
    }

    public String getNotificationAddress() {
        return notificationAddress;
    }

    public String getNotificationPayload() {
        return notificationPayload;
    }

    @Override
    public String toString() {
        return "OrderSubscriptionModel{" +
                "notificationMethod='" + notificationMethod + '\'' +
                ", notificationAddress='" + notificationAddress + '\'' +
                ", notificationPayload='" + notificationPayload + '\'' +
                '}';
    }
}
