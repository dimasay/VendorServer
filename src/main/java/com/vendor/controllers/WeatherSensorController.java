package com.vendor.controllers;

import com.vendor.models.User;
import com.vendor.models.WeatherSensor;
import com.vendor.services.WeatherSensorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/data/weather")
@PreAuthorize("hasRole('WEATHER_SENSOR')")
@AllArgsConstructor
public class WeatherSensorController implements SensorController<WeatherSensor> {
    private WeatherSensorService weatherSensorService;

    @PostMapping(consumes = "application/json")
    public void postSensorData(@RequestBody WeatherSensor weatherSensor) {
        weatherSensorService.postDataToDB(weatherSensor);
    }

    @PostMapping(consumes = "multipart/form-data")
    public void postSensorData(MultipartFile file, User user) {
        weatherSensorService.postDataToS3FromMultipartFile(file, user);
    }
}
