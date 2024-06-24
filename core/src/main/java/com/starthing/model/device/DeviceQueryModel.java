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

import com.starthing.standard.ResourceStandard;

import java.io.Serializable;

/**
 * Model for query order
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
@ResourceStandard.WithResource(version = "V1.0", code = "open.device.detail")
public final class DeviceQueryModel implements Serializable {

    /**
     * Out transaction number
     */
    private final String outTradeNumber;

    public DeviceQueryModel(String outTradeNumber) {
        this.outTradeNumber = outTradeNumber;
    }

    @Override
    public String toString() {
        return "DeviceQueryModel{" +
                ", outTradeNumber='" + outTradeNumber + '\'' +
                '}';
    }
}
