package Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Car;
import service.CarService;
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class Vehicle_Controller {

    @Autowired
    private CarService service;

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Car> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Car findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Car create(@RequestBody Car c) {
        return service.create(c);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{vin}",
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Car update(@PathVariable("vin") String vin, @RequestBody Car c) {
        return service.update(vin, c);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}
