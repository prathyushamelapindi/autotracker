package service;
import java.util.List;

import entity.Car;
public interface CarService {

	    List<Car> findAll();

	    Car findOne(String vin);

	    Car create(Car c);

	    Car update(String vin, Car c);

	    void delete(String vin);
	}


