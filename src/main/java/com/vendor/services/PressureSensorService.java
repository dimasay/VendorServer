package com.vendor.services;

import com.vendor.aws.S3Factory;
import com.vendor.models.AbstractSensor;
import com.vendor.models.PressureSensor;
import com.vendor.repositories.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class PressureSensorService extends AbstractSensorService<PressureSensor> {
    public PressureSensorService(SensorRepository<AbstractSensor> sensorRepository, S3Factory s3Factory) {
        super(sensorRepository, s3Factory);
    }
}
