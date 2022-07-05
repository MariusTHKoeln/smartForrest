package com.smartForrest.smartForrest.geojson;

public class ControllerGeoJson {

    private String type;
    private Geometry geometry;
    private GeoJsonProperties properties;

    public ControllerGeoJson() {
        this.type = "Feature";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setGeometry(String longitude, String lattitude){
    }

    public GeoJsonProperties getProperties() {
        return properties;
    }

    public void setProperties(GeoJsonProperties properties) {
        this.properties = properties;
    }
}
