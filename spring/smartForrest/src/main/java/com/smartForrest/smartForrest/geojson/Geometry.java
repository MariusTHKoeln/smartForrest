package com.smartForrest.smartForrest.geojson;

import java.math.BigDecimal;
import java.util.List;

public class Geometry {

    private String type;
    private List<Double> coordinates; //[125.6, 10.1]

    public Geometry() {
        this.type = "Point";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
