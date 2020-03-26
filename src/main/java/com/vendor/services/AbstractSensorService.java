package com.vendor.services;

import com.vendor.aws.S3Factory;
import com.vendor.models.AbstractSensor;
import com.vendor.models.User;
import com.vendor.repositories.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
public abstract class AbstractSensorService<T extends AbstractSensor> {
    private SensorRepository<AbstractSensor> sensorRepository;
    private S3Factory s3Factory;

    public void  postDataToDB(T abstractSensor) {
        sensorRepository.save(abstractSensor);
    }

    public void postDataToS3FromMultipartFile(MultipartFile multipartFile, User user) {
        s3Factory.uploadFileFromMultipart(multipartFile, user.getBucketName());
    }
}
