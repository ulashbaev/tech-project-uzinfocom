package uz.ulashbaev.classificatorservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import uz.ulashbaev.classificatorservice.dto.InitDataDto;
import uz.ulashbaev.classificatorservice.mapper.CountryMapper;
import uz.ulashbaev.classificatorservice.mapper.DistrictMapper;
import uz.ulashbaev.classificatorservice.mapper.RegionMapper;
import uz.ulashbaev.classificatorservice.model.Country;
import uz.ulashbaev.classificatorservice.model.District;
import uz.ulashbaev.classificatorservice.model.Region;
import uz.ulashbaev.classificatorservice.repository.CountryRepository;
import uz.ulashbaev.classificatorservice.repository.DistrictRepository;
import uz.ulashbaev.classificatorservice.repository.RegionRepository;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InitService {

    private final CountryRepository countryRepo;
    private final RegionRepository regionRepo;
    private final DistrictRepository districtRepo;

    private final CountryMapper countryMapper;
    private final RegionMapper regionMapper;
    private final DistrictMapper districtMapper;

    public String initDataFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("init-data.json").getInputStream();
            InitDataDto initData = objectMapper.readValue(inputStream, InitDataDto.class);

            List<Country> countries = initData.getCountries().stream()
                    .map(countryMapper::toEntity)
                    .collect(Collectors.toList());
            countryRepo.saveAll(countries);

            List<Region> regions = initData.getRegions().stream()
                    .map(regionMapper::toEntity)
                    .collect(Collectors.toList());
            regionRepo.saveAll(regions);

            List<District> districts = initData.getDistricts().stream()
                    .map(districtMapper::toEntity)
                    .collect(Collectors.toList());
            districtRepo.saveAll(districts);

            return "Initialized successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during init: " + e.getMessage();
        }
    }
}
