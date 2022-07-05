package com.smartForrest.smartForrest.services;

import com.smartForrest.smartForrest.dto.ControllerInfo;
import com.smartForrest.smartForrest.dto.TrackingInfo;
import com.smartForrest.smartForrest.geojson.ControllerGeoJson;
import com.smartForrest.smartForrest.geojson.ControllerGeoJsonWrapper;
import com.smartForrest.smartForrest.geojson.GeoJsonProperties;
import com.smartForrest.smartForrest.geojson.Geometry;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RowMapperCollection {

    RowMapper<ControllerGeoJson> controllerGeoJsonRowMapper = (resultSet, i) ->{
        ControllerGeoJson geoJson = new ControllerGeoJson();

        Geometry geometry = new Geometry();
        List<Double> coordinates= new ArrayList<>();
        coordinates.add(Double.valueOf(resultSet.getString("LONGITUDE")));
        coordinates.add(Double.valueOf(resultSet.getString("LATTITUDE")));
        geometry.setCoordinates(coordinates);
        geoJson.setGeometry(geometry);

        GeoJsonProperties properties = new GeoJsonProperties();
        properties.setName(resultSet.getString("IMEI"));
        geoJson.setProperties(properties);
        return geoJson;
    };

    RowMapper<ControllerInfo> controllerRowMapper = (resultSet, i) ->{
        ControllerInfo info = new ControllerInfo();
        info.setiMei(resultSet.getString("IMEI"));
        info.setLongitude(resultSet.getString("LONGITUDE"));
        info.setLattitude(resultSet.getString("LATTITUDE"));
        return info;
    };

    RowMapper<TrackingInfo> trackingInfoRowMapper = (resultSet, i) ->{
        TrackingInfo info = new TrackingInfo();
        info.setiMei(resultSet.getString("IMEI"));
        info.setDatetime(resultSet.getString("DATETIME"));
        info.setBatteryPercentage(resultSet.getString("BATTERYPERCENTAGE"));
        info.setBatteryVoltage(resultSet.getString("BATTERYVOLTAGE"));
        info.setSignal(resultSet.getString("SIGNAL"));
        return info;
    };
}
