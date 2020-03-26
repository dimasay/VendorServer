package com.vendor.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String bucketName;
    @NotNull
    private StorageType storageType;

    public enum StorageType {
        DATA_BASE, S3
    }
}
