package com.vendor.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public abstract class AbstractSensor {
    @javax.persistence.Id
    @Column(name = "id")
    private long id;
}
