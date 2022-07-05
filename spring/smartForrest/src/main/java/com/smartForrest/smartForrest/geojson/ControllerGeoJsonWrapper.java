package com.smartForrest.smartForrest.geojson;

import java.util.List;

public class ControllerGeoJsonWrapper {

    private String type;
    private List<ControllerGeoJson> features;

    public ControllerGeoJsonWrapper() {
        this.type = "FeatureCollection";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ControllerGeoJson> getFeatures() {
        return features;
    }

    public void setFeatures(List<ControllerGeoJson> features) {
        this.features = features;
    }
}
