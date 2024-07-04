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

import com.google.gson.JsonObject;
import com.starthing.model.ICallableModel;
import com.starthing.serializer.ObjectSerializer;
import com.starthing.standard.ResourceStandard;
import com.starthing.transform.ITenantNamespace;

import java.io.Serializable;

/**
 * Model for query order.
 *
 * <p>
 *
 * </p>
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.detail", serializer = DeviceQueryModel.DeviceQueryModelSerializer.class)
public final class DeviceQueryModel implements ICallableModel<OrderDetailModel>, Serializable {

    /**
     * Param name of {@link #deviceId}
     */
    public static final String PARAM_DEVICE_ID = "device_id";

    /**
     * Param name of {@link #outTradeNumber}
     */
    public static final String PARAM_OUT_TRADE_NUMBER = "out_trade_number";

    /**
     * Device id
     */
    private final String deviceId;

    /**
     * Out transaction number
     */
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

    /**
     * {@link ObjectSerializer} for {@link DeviceQueryModel}
     */
    public static final class DeviceQueryModelSerializer implements ObjectSerializer<DeviceQueryModel> {

        @Override
        public JsonObject serialize(ITenantNamespace namespace, DeviceQueryModel source) {
            final JsonObject root = new JsonObject();
            root.addProperty(PARAM_DEVICE_ID, source.getDeviceId());
            root.addProperty(PARAM_OUT_TRADE_NUMBER, source.getOutTradeNumber());

            return root;
        }
    }

}
