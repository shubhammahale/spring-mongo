package com.rentitout.rent.controller;

import com.rentitout.rent.model.Car;
import com.rentitout.rent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping(path = "/car")
    public List<Car> getCars(@RequestParam String type){
        return carRepository.findAllByType(type);
    }

    @GetMapping(path = "/car/{id}")
    public Optional<Car> getCarsById(@PathVariable String id){
        return carRepository.findById(id);
    }


    @GetMapping(path = "/getAllCars")
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    @PostMapping(path = "/car")
    public String saveCar(@RequestBody Car car){
        carRepository.save(car);
        return "Added car";
    }

    @DeleteMapping(path = "/car/{id}")
    public String deleteCar(@PathVariable String id){
        carRepository.deleteById(id);
        return "Deleted car";
    }

    @PatchMapping(path = "/car/{id}")
    public Optional<Car> patchCar(@PathVariable String id, @RequestBody Car car) {
        Optional<Car> carFromDB = carRepository.findById(id);
        System.out.println(car.getDescription());
        if (carFromDB.isPresent()) {
            Car carFromId = carFromDB.get();
            carFromId.setDescription(car.getDescription());
            carRepository.save(carFromId);
            return carFromDB;
        }else{
            return null;
        }
    }
    
}