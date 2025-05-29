package uz.ulashbaev.classificatorservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.ulashbaev.classificatorservice.dto.RegionDto;
import uz.ulashbaev.classificatorservice.model.Region;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    @Mapping(source = "country.id", target = "countryId")
    RegionDto toDto(Region region);

    @Mapping(source = "countryId", target = "country.id")
    Region toEntity(RegionDto dto);

    List<RegionDto> toDtoList(List<Region> regions);
}