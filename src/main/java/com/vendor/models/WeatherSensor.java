package com.vendor.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "weather")
public class WeatherSensor extends AbstractSensor {
    @Column(name = "temperature")
    private String temperature;
    @Column(name = "locationName")
    private String locationName;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
}
