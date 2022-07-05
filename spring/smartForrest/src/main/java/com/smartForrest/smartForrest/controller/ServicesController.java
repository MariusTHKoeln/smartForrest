package com.smartForrest.smartForrest.controller;

import com.smartForrest.smartForrest.dto.ControllerInfo;
import com.smartForrest.smartForrest.dto.ControllerInfoWrapper;
import com.smartForrest.smartForrest.dto.TrackingInfo;
import com.smartForrest.smartForrest.dto.TrackingInfoWrapper;
import com.smartForrest.smartForrest.geojson.ControllerGeoJsonWrapper;
import com.smartForrest.smartForrest.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@RestController
@RequestMapping("/")
public class ServicesController {

    @Autowired
    DatabaseService databaseService;

    @PostMapping("addController")
    private ResponseEntity<?> addController(@RequestBody ControllerInfo controller){
        databaseService.addMicroController(controller);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("addTracking")
    private ResponseEntity<?> addTrackingInfo(@RequestBody TrackingInfo tracking){
        databaseService.addTrackingInfo(tracking);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("controller")
    private ResponseEntity<ControllerInfoWrapper> getController(){
        return ResponseEntity.ok().body(databaseService.getController());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("controller/geoJson")
    private ResponseEntity<ControllerGeoJsonWrapper> getGeoJsonController(){
        return ResponseEntity.ok().body(databaseService.getControllerGeoJson());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("tracking/{start-time}")
    private ResponseEntity<TrackingInfoWrapper> getTrackingInfo(@PathVariable(value="start-time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime){
        return ResponseEntity.ok().body(databaseService.getTrackingInfo(startTime));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("tracking/start/{start-time}/end/{end-time}")
    private ResponseEntity<TrackingInfoWrapper> getTrackingInfo(@PathVariable(value="start-time") String startTime,
                                                                 @PathVariable(value="end-time") String endTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);

        return ResponseEntity.ok().body(databaseService.getTrackingInfo(start, end));
    }

}
