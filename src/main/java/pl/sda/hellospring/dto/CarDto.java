package pl.sda.hellospring.dto;

import lombok.Value;

@Value
public class CarDto {
    private String brand;
    private String model;
    private String color;
}
