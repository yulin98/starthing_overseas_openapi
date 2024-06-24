package com.starthing.model.device;

import java.io.Serializable;

/**
 * Model for query order
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
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
