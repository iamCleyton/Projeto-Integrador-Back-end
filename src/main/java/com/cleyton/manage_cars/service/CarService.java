package com.cleyton.manage_cars.service;
import com.cleyton.manage_cars.dto.mapper.CarMapper;
import com.cleyton.manage_cars.dto.response.CarResponseDto;
import com.cleyton.manage_cars.entity.Car;
import com.cleyton.manage_cars.repository.CarRepository;
import com.cleyton.manage_cars.repository.CarSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Transactional(readOnly = true)
    public Page<CarResponseDto> listAll(String brand, String model, Integer year, String color, Pageable pageable) {
        Specification<Car> spec = CarSpecification.filter(brand, model, year, color);
        Page<Car> page = carRepository.findAll(spec, pageable);
        return page.map(CarMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Car findbyid(Long id) {
    return carRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Cliente id=%s não encontrado no sistema", id)));
    }

    @Transactional
    public CarResponseDto partialUpdate(Long id, Map<String, Object> updates) {
        Car car = findbyid(id);

        if (updates.containsKey("brand")) {
            car.setBrand((String) updates.get("brand"));
        }
        if (updates.containsKey("model")) {
            car.setModel((String) updates.get("model"));
        }
        if (updates.containsKey("color")) {
            car.setColor((String) updates.get("color"));
        }
        if (updates.containsKey("year")) {
            car.setYear((Integer) updates.get("year"));
        }

        return CarMapper.toDto(carRepository.save(car));
    }


    @Transactional
    public void delete(Long id) {
        Car car = findbyid(id);
        carRepository.delete(car);
    }




}

