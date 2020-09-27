package pl.sda.hellospring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.hellospring.dto.CarDto;
import pl.sda.hellospring.service.CarService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    List<CarDto> findAllCars() {
        log.info("find all cars");

        return carService.getAllCars();
    }

    // car/105
    @GetMapping("/{id}")
    CarDto findCarById(@PathVariable("id") Long carId) {
        log.info("find car by id [{}]", carId);
        return carService.findCarById(carId);
    }

    // /create/?marka=toyota&model=corolla&kolor=white
    @GetMapping("/create-new")
    CarDto createNewCar(@RequestParam("marka") String brand,
                      @RequestParam("model") String model,
                      @RequestParam(value = "kolor", defaultValue = "pink") String color) {
        log.info("creating new car with brand [{}] and model [{}] and color [{}]", brand, model, color);
        var carToSave = CarDto.builder()
            .brand(brand)
            .model(model)
            .color(color)
            .build();

        return carService.saveCar(carToSave);
    }
}
