package pl.sda.hellospring.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String color;
}
