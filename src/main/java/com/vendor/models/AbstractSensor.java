package com.vendor.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@EqualsAndHashCode
public abstract class AbstractSensor {
    @javax.persistence.Id
    private long Id;
}
