package service;



//import exception.BadRequestException;
//import io.egen.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Car;
import exception.BadRequestException;
import exception.NotFoundException;
import repository.CarRepository;
import repository.CarRepositoryImpl;
import service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepositoryImpl repository;

    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Car findOne(String vin) {
        Car c = repository.findOne(vin);
        if (c == null) {
            throw new NotFoundException("Car with id=" + vin + " not found");
        }
        return c;
    }

    /* (non-Javadoc)
     * @see service.CarService#create(entity.Car)
     */
    @Override
    @Transactional
    public Car create(Car c) {
    	
        Car existing = repository.findByModel(c.getModel());
        if (existing != null) {
            throw new BadRequestException("vehicle with model=" + c.getModel() + " already exists.");
        }

        return repository.create(c);
    }

    @Override
    @Transactional
    public Car update(String vin, Car c) {
        Car existing = repository.findOne(vin);
        if (existing == null) {
            throw new NotFoundException("Employee with id=" + vin + " not found");
        }
        return repository.update(c);
    }

    @Override
    @Transactional
    public void delete(String vin) {
        Car existing = repository.findOne(vin);
        if (existing == null) {
            throw new NotFoundException("car with id=" + vin + " not found");
        }
        repository.delete(existing);
    }

	

	
}

