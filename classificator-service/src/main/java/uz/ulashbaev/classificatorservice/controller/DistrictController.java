package uz.ulashbaev.classificatorservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ulashbaev.classificatorservice.dto.DistrictDto;
import uz.ulashbaev.classificatorservice.mapper.DistrictMapper;
import uz.ulashbaev.classificatorservice.model.District;
import uz.ulashbaev.classificatorservice.model.Region;
import uz.ulashbaev.classificatorservice.repository.DistrictRepository;
import uz.ulashbaev.classificatorservice.repository.RegionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictRepository districtRepo;
    private final RegionRepository regionRepo;
    private final DistrictMapper districtMapper;

    @GetMapping
    public List<DistrictDto> all() {
        return districtMapper.toDtoList(districtRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DistrictDto dto) {
        Region region = regionRepo.findById(dto.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found"));
        District district = districtMapper.toEntity(dto);
        district.setRegion(region);
        return ResponseEntity.ok(districtMapper.toDto(districtRepo.save(district)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DistrictDto dto) {
        Region region = regionRepo.findById(dto.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found"));
        District district = districtMapper.toEntity(dto);
        district.setId(id);
        district.setRegion(region);
        return ResponseEntity.ok(districtMapper.toDto(districtRepo.save(district)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        districtRepo.deleteById(id);
    }
}