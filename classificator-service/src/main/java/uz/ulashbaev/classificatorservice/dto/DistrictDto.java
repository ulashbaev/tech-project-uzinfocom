package uz.ulashbaev.classificatorservice.dto;

import lombok.Data;

@Data
public class DistrictDto {
    private Long id;
    private String name;
    private Long regionId;
}
