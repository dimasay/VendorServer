package com.vendor.controllers;

import com.vendor.models.AbstractSensor;
import com.vendor.models.User;
import org.springframework.web.multipart.MultipartFile;

public interface SensorController<T extends AbstractSensor> {
    void postSensorData(T abstractSensor);

    void postSensorData(MultipartFile file, User user);
}
