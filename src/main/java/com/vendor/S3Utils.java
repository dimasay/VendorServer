package com.vendor;

import com.vendor.models.AbstractSensor;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class S3Utils {
    public static <T> byte[] convert(T dataToConvert){
        ObjectOutputStream out;
        try( ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
            out = new ObjectOutputStream(bos);
            out.writeObject(dataToConvert);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }
}
