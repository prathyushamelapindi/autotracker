package repository;

import entity.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();

    Car findOne(String id);

    Car findByModel(String model);

    Car create(Car emp);

    Car update(Car emp);

    void delete(Car emp);
}
