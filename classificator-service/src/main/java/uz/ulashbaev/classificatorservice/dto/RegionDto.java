package uz.ulashbaev.classificatorservice.dto;

import lombok.Data;

@Data
public class RegionDto {
    private Long id;
    private String name;
    private Long countryId;
}
