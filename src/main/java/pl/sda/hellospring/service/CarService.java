package pl.sda.hellospring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.hellospring.converter.CarConverter;
import pl.sda.hellospring.domain.Car;
import pl.sda.hellospring.dto.CarDto;
import pl.sda.hellospring.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    public CarService(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    public List<CarDto> getAllCars() {
        List<CarDto> result = new ArrayList<>();

        var dataFromRepo = new ArrayList<Car>();
        carRepository.findAll()
//            .forEach(car -> dataFromRepo.add(car));
            .forEach(dataFromRepo::add);

        result = dataFromRepo.stream()
//            .map(car -> carConverter.fromEntityToDto(car))
            .map(carConverter::fromEntityToDto)
            .collect(Collectors.toList());

        log.debug("all cars: {}", result);
        return result;
    }
}
