package uz.ulashbaev.classificatorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ulashbaev.classificatorservice.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}