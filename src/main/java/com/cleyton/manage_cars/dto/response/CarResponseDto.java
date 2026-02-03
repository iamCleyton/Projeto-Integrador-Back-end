package com.cleyton.manage_cars.dto.response;

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
}
