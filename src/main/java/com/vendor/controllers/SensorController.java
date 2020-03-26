package com.vendor.controllers;

import com.vendor.models.AbstractSensor;
import com.vendor.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface SensorController {
    void postSensorData(AbstractSensor abstractSensor, User user);

    void postSensorData(MultipartFile file, User user);
}
