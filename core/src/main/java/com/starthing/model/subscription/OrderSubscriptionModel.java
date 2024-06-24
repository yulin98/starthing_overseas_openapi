/*
 * Copyright 2024 starthing_overseas_openapi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
