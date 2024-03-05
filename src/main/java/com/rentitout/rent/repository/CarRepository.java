package com.rentitout.rent.repository;

import com.rentitout.rent.model.Car;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String> {
    public List<Car> findAllByType(String type);
}
