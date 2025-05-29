package uz.ulashbaev.classificatorservice.mapper;

import org.mapstruct.Mapper;
import uz.ulashbaev.classificatorservice.dto.CountryDto;
import uz.ulashbaev.classificatorservice.model.Country;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto toDto(Country country);
    Country toEntity(CountryDto dto);
    List<CountryDto> toDtoList(List<Country> countries);
}
