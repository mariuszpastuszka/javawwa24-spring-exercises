package pl.sda.hellospring.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.hellospring.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
