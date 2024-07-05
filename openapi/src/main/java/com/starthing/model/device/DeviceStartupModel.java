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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.starthing.model.ICallableModel;
import com.starthing.model.subscription.OrderSubscriptionModel;
import com.starthing.standard.ResourceStandard;

import java.io.Serializable;

/**
 * Model for device start-up
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.startup")
public final class DeviceStartupModel implements ICallableModel<OrderDetailModel>, Serializable {

    /**
     * Device id
     */
    @JsonProperty("device_id")
    private final String deviceId;

    /**
     * Out transaction number
     */
    @JsonProperty("out_trade_number")
    private final String outTradeNumber;

    /**
     * Device setup parameter
     */
    @JsonProperty("setup_parameter")
    private final SetupParameterModel setup;

    /**
     * Subscribe order result.
     */
    @JsonProperty("subscription")
    private final OrderSubscriptionModel subscription;

    public DeviceStartupModel(String deviceId, String outTradeNumber, SetupParameterModel setup, OrderSubscriptionModel subscription) {
        this.deviceId = deviceId;
        this.outTradeNumber = outTradeNumber;
        this.setup = setup;
        this.subscription = subscription;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getOutTradeNumber() {
        return outTradeNumber;
    }

    public SetupParameterModel getSetup() {
        return setup;
    }

    public OrderSubscriptionModel getSubscription() {
        return subscription;
    }

    @Override
    public String toString() {
        return "DeviceStartupModel{" +
                "deviceId='" + deviceId + '\'' +
                ", outTradeNumber='" + outTradeNumber + '\'' +
                ", setupParameter=" + setup +
                ", subscription=" + subscription +
                '}';
    }

}
