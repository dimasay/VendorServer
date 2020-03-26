package com.vendor.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.vendor.S3Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@AllArgsConstructor
public class S3Factory {
    private AmazonS3 amazonS3;

    public void uploadFileFromMultipart(MultipartFile multipartFile, String bucketName) {
        try {
            File file = File.createTempFile(multipartFile.getName(), ".csv");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                byte[] content = S3Utils.convert(multipartFile);
                if (content != null) {
                    fileOutputStream.write(content);
                    amazonS3.putObject(bucketName, file.getAbsolutePath(), file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}