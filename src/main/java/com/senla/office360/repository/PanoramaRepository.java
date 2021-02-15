package com.senla.office360.repository;

import com.senla.office360.entity.Panorama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanoramaRepository extends JpaRepository<Panorama, Integer> {
}