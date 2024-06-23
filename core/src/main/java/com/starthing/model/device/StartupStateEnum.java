package com.starthing.model.device;

/**
 * Enum for device startup state
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public enum StartupStateEnum {

    ACCEPTED("ACCEPTED"),

    ISSUED("ISSUED"),

    FAILED("FAILED");

    /**
     * Real state
     */
    private final String real;

    StartupStateEnum(String real) {
        this.real = real;
    }

    public String getReal() {
        return real;
    }

    @Override
    public String toString() {
        return "StartupStateEnum{" +
                "real='" + real + '\'' +
                '}';
    }
}
