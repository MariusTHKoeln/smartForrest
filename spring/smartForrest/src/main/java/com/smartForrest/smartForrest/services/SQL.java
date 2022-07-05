package com.smartForrest.smartForrest.services;

public enum SQL {

    INSERT_CONTROLLER("INSERT INTO MICROCONTROLLER (IMEI, LONGITUDE, LATTITUDE) VALUES (?, ?, ?)"),
    INSERT_TRACKING_INFO("INSERT INTO TRACKING (IMEI, DATETIME, BATTERYPERCENTAGE, BATTERYVOLTAGE, SIGNAL) VALUES (?, ?, ?, ?, ?)"),
    SELECT_MICROCONTROLLER("SELECT * FROM MICROCONTROLLER"),
    SELECT_TRACKINGINFO_FROM("SELECT * FROM TRACKING WHERE DATETIME >= ?"),
    SELECT_TRACKINGINFO_FROM_UNTIL("SELECT * FROM TRACKING WHERE DATETIME >= ? AND DATETIME <=?");

    private String sqlCommand;

    SQL(String sqlCommand){
        this.sqlCommand = sqlCommand;
    }
    public String getSql(){
        return sqlCommand;
    }
}
