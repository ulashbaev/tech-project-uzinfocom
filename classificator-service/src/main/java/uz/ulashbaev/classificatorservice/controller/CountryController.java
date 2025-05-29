package uz.ulashbaev.classificatorservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.ulashbaev.classificatorservice.dto.CountryDto;
import uz.ulashbaev.classificatorservice.mapper.CountryMapper;
import uz.ulashbaev.classificatorservice.model.Country;
import uz.ulashbaev.classificatorservice.repository.CountryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    @GetMapping
    public List<CountryDto> all() {
        return mapper.toDtoList(repository.findAll());
    }

    @PostMapping
    public CountryDto create(@RequestBody CountryDto dto) {
        Country saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public CountryDto update(@PathVariable Long id, @RequestBody CountryDto dto) {
        Country country = mapper.toEntity(dto);
        country.setId(id);
        return mapper.toDto(repository.save(country));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
