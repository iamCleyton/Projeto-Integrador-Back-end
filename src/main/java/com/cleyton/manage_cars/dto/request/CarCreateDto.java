package com.cleyton.manage_cars.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CarCreateDto {
    private String model;
    private String brand;
    private String color;
    private Integer year;
    private LocalDateTime releaseDate;
}
