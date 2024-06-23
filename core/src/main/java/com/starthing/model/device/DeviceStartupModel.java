package com.starthing.model.device;

import com.starthing.model.subscription.OrderSubscriptionModel;

import java.io.Serializable;

/**
 * Model for device start-up
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public final class DeviceStartupModel implements Serializable {

    /**
     * Device id
     */
    private final String deviceId;

    /**
     * Out transaction number
     */
    private final String outTradeNumber;

    /**
     * Device setup parameter
     */
    private final SetupParameterModel setupParameter;

    /**
     * Subscribe order result.
     */
    private final OrderSubscriptionModel subscription;

    public DeviceStartupModel(String deviceId, String outTradeNumber, SetupParameterModel setupParameter, OrderSubscriptionModel subscription) {
        this.deviceId = deviceId;
        this.outTradeNumber = outTradeNumber;
        this.setupParameter = setupParameter;
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "DeviceStartupModel{" +
                "deviceId='" + deviceId + '\'' +
                ", outTradeNumber='" + outTradeNumber + '\'' +
                ", setupParameter=" + setupParameter +
                ", subscription=" + subscription +
                '}';
    }
}
