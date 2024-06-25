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

import com.starthing.model.ICallableModel;
import com.starthing.model.subscription.OrderSubscriptionModel;
import com.starthing.standard.ResourceStandard;

import java.io.Serializable;

/**
 * Model for device start-up
 *
 * @author wunhwantseng@gmail.co**open.device.startup**m
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.startup")
public final class DeviceStartupModel implements ICallableModel<OrderDetailModel>, Serializable {

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
