package pl.sda.hellospring.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sda.hellospring.domain.Car;
import pl.sda.hellospring.dto.CarDto;

@Component
@Slf4j
public class CarConverter implements GenericConverter<Car, CarDto> {

    @Override
    public CarDto fromEntityToDto(Car entity) {
        var carDto = CarDto.builder()
            .brand(entity.getBrand())
            .color(entity.getColor())
            .model(entity.getModel())
            .build();
        log.info("converting entity [{}] to dto [{}]", entity, carDto);

        return carDto;
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        var result = new Car(null, dto.getBrand(), dto.getModel(), dto.getColor());

        log.info("converging dto [{}] to entity [{}]", dto, result);
        return result;
    }
}
