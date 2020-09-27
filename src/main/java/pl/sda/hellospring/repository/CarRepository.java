package pl.sda.hellospring.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.hellospring.domain.Car;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findByBrandAndColor(String brand, String color);
}
