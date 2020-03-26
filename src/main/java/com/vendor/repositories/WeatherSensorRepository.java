package com.vendor.repositories;

import com.vendor.models.WeatherSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherSensorRepository extends JpaRepository<WeatherSensor, Long> {
    List<WeatherSensor> findById(long id);
}
