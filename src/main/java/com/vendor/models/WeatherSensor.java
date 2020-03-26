package com.vendor.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class WeatherSensor extends AbstractSensor {
    private String temperature;
    private String locationName;
    private String latitude;
    private String longitude;
}
