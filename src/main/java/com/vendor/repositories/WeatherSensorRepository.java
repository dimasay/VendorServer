package com.vendor.repositories;

import com.vendor.models.WeatherSensor;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherSensorRepository extends SensorRepository <WeatherSensor> {
}
