package pl.sda.hellospring.converter;

import pl.sda.hellospring.domain.Car;
import pl.sda.hellospring.dto.CarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarConverterMapStruct extends GenericConverter<Car, CarDto> {
}
