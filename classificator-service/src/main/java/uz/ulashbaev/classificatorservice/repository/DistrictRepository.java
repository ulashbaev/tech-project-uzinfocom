package uz.ulashbaev.classificatorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ulashbaev.classificatorservice.model.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
}