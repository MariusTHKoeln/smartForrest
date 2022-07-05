package com.smartForrest.smartForrest.services;

import com.smartForrest.smartForrest.dto.ControllerInfo;
import com.smartForrest.smartForrest.dto.ControllerInfoWrapper;
import com.smartForrest.smartForrest.dto.TrackingInfo;
import com.smartForrest.smartForrest.dto.TrackingInfoWrapper;
import com.smartForrest.smartForrest.geojson.ControllerGeoJsonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DatabaseService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RowMapperCollection rowMapper;

    public void addMicroController(ControllerInfo controller){
        jdbcTemplate.update(SQL.INSERT_CONTROLLER.getSql(), controller.getiMei(), controller.getLongitude(), controller.getLattitude());
    }

    public void addTrackingInfo(TrackingInfo trackingInfo){
        jdbcTemplate.update(SQL.INSERT_TRACKING_INFO.getSql(), trackingInfo.getiMei(), trackingInfo.getDatetime(), trackingInfo.getBatteryPercentage(), trackingInfo.getBatteryVoltage(), trackingInfo.getSignal());
    }

    public ControllerInfoWrapper getController(){
        ControllerInfoWrapper wrapper = new ControllerInfoWrapper();
        wrapper.setController(jdbcTemplate.query(SQL.SELECT_MICROCONTROLLER.getSql(), rowMapper.controllerRowMapper));
        return wrapper;
    }

    public ControllerGeoJsonWrapper getControllerGeoJson(){
        ControllerGeoJsonWrapper wrapper = new ControllerGeoJsonWrapper();
        wrapper.setFeatures(jdbcTemplate.query(SQL.SELECT_MICROCONTROLLER.getSql(), rowMapper.controllerGeoJsonRowMapper));
        return wrapper;
    }

    public TrackingInfoWrapper getTrackingInfo(LocalDateTime startTime){
        TrackingInfoWrapper wrapper = new TrackingInfoWrapper();
        wrapper.setTrackingInfo(jdbcTemplate.query(SQL.SELECT_TRACKINGINFO_FROM.getSql(), rowMapper.trackingInfoRowMapper, startTime));
        return wrapper;
    }

    public TrackingInfoWrapper getTrackingInfo(LocalDateTime startTime, LocalDateTime endTime){
        TrackingInfoWrapper wrapper = new TrackingInfoWrapper();
        wrapper.setTrackingInfo(jdbcTemplate.query(SQL.SELECT_TRACKINGINFO_FROM_UNTIL.getSql(), rowMapper.trackingInfoRowMapper, startTime, endTime));
        return wrapper;
    }

}
