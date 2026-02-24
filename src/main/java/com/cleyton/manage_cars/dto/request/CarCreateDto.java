package com.cleyton.manage_cars.dto.request;

import jakarta.validation.constraints.*;
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

    @NotBlank
    @Size(min = 2, message = "The model must have at least 2 characters.")
    private String model;

    @NotBlank
    @Size(min = 2, message = "The brand must have at least 2 characters.")
    private String brand;

    @NotBlank
    @Size(min = 2, message = "The color must have at least 2 characters.")
    private String color;

    @NotNull
        @Min(value = 1920, message = "The year must be after 1919")
    @Max(value = 2027, message = "The year must be before 2028")
    private Integer year;


    private LocalDateTime releaseDate;
}
