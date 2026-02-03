package com.cleyton.manage_cars.repository;

import com.cleyton.manage_cars.entity.Car;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class CarSpecification {
    public static Specification<Car> filter(String brand, String model, Integer year, String color) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (brand != null && !brand.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("brand")), "%" + brand.toLowerCase() + "%"));
            }
            if (model != null && !model.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.get("modelo")), model.toLowerCase()));
            }
            if (year != null) {
                predicates.add(cb.equal(root.get("year"), year));
            }
            if (color != null && !color.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.get("cor")), color.toLowerCase()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}