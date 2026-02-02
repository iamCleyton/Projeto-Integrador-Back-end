package com.cleyton.manage_cars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "carros")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "brand", nullable = false, length = 20)
    private String brand;

    @Column(name = "color", nullable = false, length = 20)
    private String color;

    @Column(name = "year", nullable = false, length = 4)
    private int year;

    @Column(name = "realase_date", nullable = false)
    private LocalDateTime realaseDate;


    @CreatedDate
    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime dataModified;

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
