package com.vendor.repositories;

import com.vendor.models.AbstractSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository<T extends AbstractSensor> extends JpaRepository<T, Long> {
}
