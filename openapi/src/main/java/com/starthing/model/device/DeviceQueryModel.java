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
import com.starthing.standard.ResourceStandard;

import java.io.Serializable;

/**
 * Model for query order.
 *
 * <p>
 *
 * </p>
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.detail")
public final class DeviceQueryModel implements ICallableModel<OrderDetailModel>, Serializable {

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

    public DeviceQueryModel(String deviceId, String outTradeNumber) {
        this.deviceId = deviceId;
        this.outTradeNumber = outTradeNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getOutTradeNumber() {
        return outTradeNumber;
    }

    @Override
    public String toString() {
        return "DeviceQueryModel{" +
                "deviceId='" + deviceId + '\'' +
                ", outTradeNumber='" + outTradeNumber + '\'' +
                '}';
    }

}
