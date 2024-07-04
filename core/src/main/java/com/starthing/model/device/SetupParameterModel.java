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

import java.io.Serializable;

/**
 * Model for device setup parameter
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public final class SetupParameterModel implements Serializable {

    /**
     * Param name of {@link #generalDevice}
     */
    public static final String PARAM_GENERAL_DEVICE = "general_device";

    /**
     * Param name of {@link #matrixXDevice}
     */
    public static final String PARAM_MATRIX_X_DEVICE = "matrix_x_device";

    /**
     * Param name of {@link #matrixYDevice}
     */
    public static final String PARAM_MATRIX_Y_DEVICE = "matrix_y_device";

    /**
     * General device parameter
     */
    private final String generalDevice;

    /**
     * Matrix-X device parameter
     */
    private final String matrixXDevice;

    /**
     * Matrix-Y device parameter
     */
    private final String matrixYDevice;

    public SetupParameterModel(String generalDevice, String matrixXDevice, String matrixYDevice) {
        this.generalDevice = generalDevice;
        this.matrixXDevice = matrixXDevice;
        this.matrixYDevice = matrixYDevice;
    }

    public String getGeneralDevice() {
        return generalDevice;
    }

    public String getMatrixXDevice() {
        return matrixXDevice;
    }

    public String getMatrixYDevice() {
        return matrixYDevice;
    }

    @Override
    public String toString() {
        return "SetupParameter{" +
                "generalDevice='" + generalDevice + '\'' +
                ", matrixXDevice='" + matrixXDevice + '\'' +
                ", matrixYDevice='" + matrixYDevice + '\'' +
                '}';
    }
}
