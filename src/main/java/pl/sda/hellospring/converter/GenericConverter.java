package pl.sda.hellospring.converter;

public interface GenericConverter<R, T> {

    T fromEntityToDto(R entity);
    R fromDtoToEntity(T dto);
}
