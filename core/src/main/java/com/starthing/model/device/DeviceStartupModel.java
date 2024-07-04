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
import com.starthing.model.subscription.OrderSubscriptionModel;
import com.starthing.serializer.ObjectSerializer;
import com.starthing.standard.ResourceStandard;
import com.starthing.transform.ITenantNamespace;

import java.io.Serializable;

/**
 * Model for device start-up
 *
 * @author wunhwantseng@gmail.co**open.device.startup**m
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.startup", serializer = DeviceStartupModel.DeviceStartupModelSerializer.class)
public final class DeviceStartupModel implements ICallableModel<OrderDetailModel>, Serializable {

    /**
     * Param name of {@link #deviceId}
     */
    public static final String PARAM_DEVICE_ID = "device_id";

    /**
     * Param name of {@link #outTradeNumber}
     */
    public static final String PARAM_OUT_TRADE_NUMBER = "out_trade_number";

    /**
     * Param name of {@link #setupParameter}
     */
    public static final String PARAM_SETUP_PARAMETER = "setup_parameter";

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

    public String getDeviceId() {
        return deviceId;
    }

    public String getOutTradeNumber() {
        return outTradeNumber;
    }

    public SetupParameterModel getSetupParameter() {
        return setupParameter;
    }

    public OrderSubscriptionModel getSubscription() {
        return subscription;
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

    /**
     * {@link ObjectSerializer} for {@link DeviceStartupModel}
     */
    public static final class DeviceStartupModelSerializer implements ObjectSerializer<DeviceStartupModel> {

        @Override
        public JsonObject serialize(ITenantNamespace namespace, DeviceStartupModel source) {
            final JsonObject root = new JsonObject();
            root.addProperty(PARAM_DEVICE_ID, source.getDeviceId());
            root.addProperty(PARAM_OUT_TRADE_NUMBER, source.getOutTradeNumber());
            root.addProperty(PARAM_SETUP_PARAMETER, source.getSetupParameter());

            return root;
        }
    }

}
