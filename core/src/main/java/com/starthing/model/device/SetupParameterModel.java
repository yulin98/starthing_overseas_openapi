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
