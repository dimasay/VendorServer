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
        switch (user.getStorageType()) {
            case DATA_BASE:
                weatherSensorService.postDataToDB(abstractSensor);
                break;
            case S3:
                weatherSensorService.postDataToS3FromObject(abstractSensor, user);
                break;
        }
    }

    @PostMapping(consumes = "multipart/form-data")
    public void postSensorData(MultipartFile file, @AuthenticationPrincipal User user) {
        switch (user.getStorageType()) {
            case DATA_BASE:
                //тут будет реализация
//                weatherSensorService.postDataToDB(file);
                break;
            case S3:
                weatherSensorService.postDataToS3FromMultipartFile(file, user);
                break;
        }
    }
}
