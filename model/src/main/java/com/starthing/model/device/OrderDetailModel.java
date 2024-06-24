package com.starthing.model.device;

import com.starthing.model.subscription.OrderSubscriptionModel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model for device startup order
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 2024/06/24
 */
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

    public OrderDetailModel(String deviceId, String outTransactionNumber, StartupStatusEnum orderStatus, LocalDateTime createdTime, LocalDateTime issuedTime, String failureReason, String notificationCallback) {
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
