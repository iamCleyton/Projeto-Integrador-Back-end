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

            // MARCA: Aceita pedaço da palavra (LIKE)
            if (brand != null && !brand.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("brand")), "%" + brand.toLowerCase() + "%"));
            }

            // MODELO: Alterado para aceitar pedaço da palavra (LIKE)
            if (model != null && !model.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("model")), "%" + model.toLowerCase() + "%"));
            }

            // ANO: Mantém igual (EQUAL), pois ano é número inteiro
            if (year != null) {
                predicates.add(cb.equal(root.get("year"), year));
            }

            // COR: Alterado para aceitar pedaço da palavra (LIKE)
            if (color != null && !color.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("color")), "%" + color.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}