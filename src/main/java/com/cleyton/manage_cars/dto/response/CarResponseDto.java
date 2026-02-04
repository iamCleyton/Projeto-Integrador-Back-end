package com.cleyton.manage_cars.dto.response;

import com.cleyton.manage_cars.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CarResponseDto {
    private Long id;
    private String model;
    private String brand;
    private String color;
    private Integer year;
    private LocalDateTime releaseDate;

    public CarResponseDto(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.brand = car.getBrand();
        this.color = car.getColor();
        this.year = car.getYear();
        this.releaseDate = car.getReleaseDate();
    }
}
