package uz.ulashbaev.classificatorservice.mapper;

import org.mapstruct.*;
import uz.ulashbaev.classificatorservice.dto.DistrictDto;
import uz.ulashbaev.classificatorservice.model.District;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistrictMapper {

    @Mapping(source = "region.id", target = "regionId")
    DistrictDto toDto(District district);

    @Mapping(source = "regionId", target = "region.id")
    District toEntity(DistrictDto dto);

    List<DistrictDto> toDtoList(List<District> districts);
}