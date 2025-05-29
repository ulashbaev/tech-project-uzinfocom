package uz.ulashbaev.classificatorservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ulashbaev.classificatorservice.dto.RegionDto;
import uz.ulashbaev.classificatorservice.mapper.RegionMapper;
import uz.ulashbaev.classificatorservice.model.Country;
import uz.ulashbaev.classificatorservice.model.Region;
import uz.ulashbaev.classificatorservice.repository.CountryRepository;
import uz.ulashbaev.classificatorservice.repository.RegionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionRepository regionRepo;
    private final CountryRepository countryRepo;
    private final RegionMapper regionMapper;

    @GetMapping
    public List<RegionDto> all() {
        return regionMapper.toDtoList(regionRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RegionDto dto) {
        Country country = countryRepo.findById(dto.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        Region region = regionMapper.toEntity(dto);
        region.setCountry(country);
        return ResponseEntity.ok(regionMapper.toDto(regionRepo.save(region)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RegionDto dto) {
        Country country = countryRepo.findById(dto.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        Region region = regionMapper.toEntity(dto);
        region.setId(id);
        region.setCountry(country);
        return ResponseEntity.ok(regionMapper.toDto(regionRepo.save(region)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        regionRepo.deleteById(id);
    }
}