package com.vendor.services;

import com.vendor.aws.S3Factory;
import com.vendor.models.AbstractSensor;
import com.vendor.models.User;
import com.vendor.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
public abstract class AbstractSensorService {
    private SensorRepository<AbstractSensor> sensorRepository;
    private S3Factory s3Factory;

    public void postDataToDB(AbstractSensor abstractSensor) {
        sensorRepository.save(abstractSensor);
    }

    public void postDataToS3FromMultipartFile(MultipartFile multipartFile, User user) {
        s3Factory.uploadFileFromMultipart(multipartFile, user.getBucketName());
    }
}
