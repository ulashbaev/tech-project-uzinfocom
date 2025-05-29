package uz.ulashbaev.classificatorservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InitDataDto {
    private List<CountryDto> countries;
    private List<RegionDto> regions;
    private List<DistrictDto> districts;

    public List<CountryDto> getCountries() {
        return countries;
    }

    public List<RegionDto> getRegions() {
        return regions;
    }

    public List<DistrictDto> getDistricts() {
        return districts;
    }

    public void setCountries(List<CountryDto> countries) {
        this.countries = countries;
    }

    public void setRegions(List<RegionDto> regions) {
        this.regions = regions;
    }

    public void setDistricts(List<DistrictDto> districts) {
        this.districts = districts;
    }
}
