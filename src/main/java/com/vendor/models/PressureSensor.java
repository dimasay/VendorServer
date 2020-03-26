package com.vendor.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "pressure")
public class PressureSensor extends AbstractSensor {
    @Column(name = "pressure")
    private String pressure;
    @Column(name = "location")
    private String location;
    @Column(name = "height")
    private String height;
}
