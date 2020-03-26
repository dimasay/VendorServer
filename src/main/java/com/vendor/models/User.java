package com.vendor.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private long id;
    @NonNull
    @Column(name = "vendorName")
    private String vendorName;
    @Column(name = "password")
    private String password;
    @NonNull
    @Column(name = "bucketName")
    private String bucketName;
    @Column(name = "role")
    @NotNull
    private String role;
    @Column(name = "authToken")
    private String authToken;
}
