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
package com.starthing.model.device;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.starthing.model.subscription.OrderSubscriptionModel;
import com.starthing.standard.FormatStandard;
import com.starthing.standard.ResourceStandard;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model for device startup order
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.notification")
public final class OrderDetailModel implements Serializable {

    /**
     * Device id
     */
    private final String deviceId;

    /**
     * Out transaction number
     */
    private final String outTransactionNumber;

    /**
     * Order status
     */
    private final StartupStatusEnum orderStatus;

    /**
     * Created time
     */
    private final LocalDateTime createdTime;

    /**
     * Issued time
     */
    private final LocalDateTime issuedTime;

    /**
     * Failure reason
     */
    private final String failureReason;

    /**
     * Notification callback.
     *
     * @see OrderSubscriptionModel#getNotificationPayload()
     */
    private final String notificationCallback;

    public OrderDetailModel(
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("out_trade_number") String outTransactionNumber,
            @JsonProperty("order_status") StartupStatusEnum orderStatus,
            @JsonProperty("created_time") @JsonFormat(pattern = FormatStandard.STANDARD_DATETIME_FORMAT) LocalDateTime createdTime,
            @Nullable @JsonProperty("issued_time") @JsonFormat(pattern = FormatStandard.STANDARD_DATETIME_FORMAT) LocalDateTime issuedTime,
            @Nullable @JsonProperty("failure_reason") String failureReason,
            @Nullable @JsonProperty("notification_callback") String notificationCallback
    ) {
        this.deviceId = deviceId;
        this.outTransactionNumber = outTransactionNumber;
        this.orderStatus = orderStatus;
        this.createdTime = createdTime;
        this.issuedTime = issuedTime;
        this.failureReason = failureReason;
        this.notificationCallback = notificationCallback;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getOutTransactionNumber() {
        return outTransactionNumber;
    }

    public StartupStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getIssuedTime() {
        return issuedTime;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public String getNotificationCallback() {
        return notificationCallback;
    }

    @Override
    public String toString() {
        return "OrderDetailModel{" +
                "deviceId='" + deviceId + '\'' +
                ", outTransactionNumber='" + outTransactionNumber + '\'' +
                ", orderStatus=" + orderStatus +
                ", createdTime=" + createdTime +
                ", issuedTime=" + issuedTime +
                ", failureReason='" + failureReason + '\'' +
                ", notificationCallback='" + notificationCallback + '\'' +
                '}';
    }
}
