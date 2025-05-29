package uz.ulashbaev.classificatorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ulashbaev.classificatorservice.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}