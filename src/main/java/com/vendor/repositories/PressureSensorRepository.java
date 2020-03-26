package com.vendor.repositories;

import com.vendor.models.PressureSensor;
import org.springframework.stereotype.Repository;

@Repository
public interface PressureSensorRepository extends SensorRepository<PressureSensor> {
}
