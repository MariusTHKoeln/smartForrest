package com.smartForrest.smartForrest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackingInfo {

    @JsonProperty("i")
    private String iMei;
    @JsonProperty("t")
    private String datetime;
    @JsonProperty("bP")
    private String batteryPercentage;
    @JsonProperty("bV")
    private String batteryVoltage;
    @JsonProperty("s")
    private String signal;

    public String getiMei() {
        return iMei;
    }

    public void setiMei(String iMei) {
        this.iMei = iMei;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(String batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }
}
