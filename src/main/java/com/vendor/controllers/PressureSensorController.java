package com.vendor.controllers;

import com.vendor.models.PressureSensor;
import com.vendor.models.User;
import com.vendor.services.PressureSensorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@PreAuthorize("hasRole('PRESSURE_SENSOR')")
public class PressureSensorController implements SensorController<PressureSensor> {
    private PressureSensorService pressureSensorService;

    @Override
    public void postSensorData(PressureSensor pressureSensor) {
        pressureSensorService.postDataToDB(pressureSensor);
    }

    @Override
    public void postSensorData(MultipartFile file, User user) {
        pressureSensorService.postDataToS3FromMultipartFile(file, user);
    }
}
