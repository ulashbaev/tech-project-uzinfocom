package uz.ulashbaev.classificatorservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class InitDataDto {
    private List<CountryDto> countries;
    private List<RegionDto> regions;
    private List<DistrictDto> districts;
}
