package com.cleyton.manage_cars.service;
import com.cleyton.manage_cars.dto.mapper.CarMapper;
import com.cleyton.manage_cars.dto.request.CarUpdateDto;
import com.cleyton.manage_cars.dto.response.CarResponseDto;
import com.cleyton.manage_cars.entity.Car;
import com.cleyton.manage_cars.exception.EntityNotFoundException;
import com.cleyton.manage_cars.repository.CarRepository;
import com.cleyton.manage_cars.repository.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;


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
        () -> new EntityNotFoundException(String.format(String.format("Car id=%s not found in the system", id))));
    }


    /*Busca o carro no banco pelo id na url
    Depois Verifica:
    Se o campo no dto não for nulo (não tiver vazio),
    significa que o usuario enviou um valor em algum atributo,
    Logo, esse valor é atualizado, mas se o valor for nulo,
    não haverá mudança no valor não digitado.

     */
    @Transactional
    public CarResponseDto partialUpdate(Long id, CarUpdateDto dto) {
        Car car = findbyid(id);

        if (dto.getBrand() != null) {
            car.setBrand(dto.getBrand());
        }
        if (dto.getModel() != null) {
            car.setModel(dto.getModel());
        }
        if (dto.getColor() != null) {
            car.setColor(dto.getColor());
        }
        if (dto.getYear() != null) {
            car.setYear(dto.getYear());
        }
        if (dto.getReleaseDate() != null) {
            car.setReleaseDate(dto.getReleaseDate());
        }

        return new CarResponseDto(car);
    }


    @Transactional
    public void delete(Long id) {
        Car car = findbyid(id);
        carRepository.delete(car);
    }




}

