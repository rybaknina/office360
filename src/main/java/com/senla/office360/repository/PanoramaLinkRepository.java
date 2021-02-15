package com.senla.office360.repository;

import com.senla.office360.entity.PanoramaLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanoramaLinkRepository extends JpaRepository<PanoramaLink, Integer> {
}