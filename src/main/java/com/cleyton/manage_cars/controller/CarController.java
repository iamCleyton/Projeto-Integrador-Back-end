package com.cleyton.manage_cars.controller;


import com.cleyton.manage_cars.dto.mapper.CarMapper;
import com.cleyton.manage_cars.dto.request.CarCreateDto;
import com.cleyton.manage_cars.dto.request.CarUpdateDto;
import com.cleyton.manage_cars.dto.response.CarResponseDto;
import com.cleyton.manage_cars.entity.Car;
import com.cleyton.manage_cars.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/car")
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarResponseDto> create(
         @Valid @RequestBody CarCreateDto dto) {
        Car car = CarMapper.toCar(dto);
        Car savedCar = carService.save(car);
        CarResponseDto response = CarMapper.toDto(savedCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDto> getById(@PathVariable Long id) {
        Car car = carService.findbyid(id);
        return ResponseEntity.ok(CarMapper.toDto(car));
    }

    @GetMapping
    public ResponseEntity<Page<CarResponseDto>> getAll(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer year,
            Pageable pageable) {

        return ResponseEntity.ok(carService.listAll(brand, model, year, color, pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarResponseDto> PartialUpdate(@PathVariable Long id, @RequestBody @Valid CarUpdateDto dto) {

        return ResponseEntity.ok(carService.partialUpdate(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
