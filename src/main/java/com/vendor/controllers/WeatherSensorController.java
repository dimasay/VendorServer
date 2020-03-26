package com.vendor.controllers;

import com.vendor.models.AbstractSensor;
import com.vendor.models.User;
import com.vendor.services.WeatherSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/data/weather")
@RequiredArgsConstructor
public class WeatherSensorController implements SensorController {
    private WeatherSensorService weatherSensorService;

    @PostMapping(consumes = "application/json")
    public void postSensorData(AbstractSensor abstractSensor, @AuthenticationPrincipal User user) {
        weatherSensorService.postDataToDB(abstractSensor);
    }

    @PostMapping(consumes = "multipart/form-data")
    public void postSensorData(MultipartFile file, @AuthenticationPrincipal User user) {
        weatherSensorService.postDataToS3FromMultipartFile(file, user);
    }
}
