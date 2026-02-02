package com.cleyton.manage_cars.repository;

import com.cleyton.manage_cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
