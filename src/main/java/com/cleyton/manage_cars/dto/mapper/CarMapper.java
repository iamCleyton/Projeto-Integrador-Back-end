package com.cleyton.manage_cars.dto.mapper;


import com.cleyton.manage_cars.dto.request.CarCreateDto;
import com.cleyton.manage_cars.dto.response.CarResponseDto;
import com.cleyton.manage_cars.entity.Car;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarMapper {

    public static Car toCar(CarCreateDto dto) {
        return new ModelMapper().map(dto, Car.class);
    }

    public static CarResponseDto toDto(Car car) {
        return new ModelMapper().map(car, CarResponseDto.class);
    }

}
