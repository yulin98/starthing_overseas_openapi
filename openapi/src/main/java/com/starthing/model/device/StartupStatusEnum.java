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

/**
 * Enum for device startup state
 *
 * @author <a href="mailto:zhengwenhuan@leyaoyao.com">Vincent-Zheng</a>
 * @since 0.0.1
 */
public enum StartupStatusEnum {

    /**
     * Accepted command
     */
    ACCEPTED("ACCEPTED"),

    /**
     * Successful startup
     */
    ISSUED("ISSUED"),

    /**
     * Failure startup
     */
    FAILED("FAILED");

    /**
     * Real state
     */
    private final String real;

    StartupStatusEnum(String real) {
        this.real = real;
    }

    public String getReal() {
        return real;
    }

    @Override
    public String toString() {
        return "StartupStatusEnum{" +
                "real='" + real + '\'' +
                '}';
    }
}
