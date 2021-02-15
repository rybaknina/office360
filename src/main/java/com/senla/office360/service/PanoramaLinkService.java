package com.senla.office360.service;

import com.senla.office360.entity.PanoramaLink;

import java.util.List;
import java.util.Optional;

public interface PanoramaLinkService {
    List<PanoramaLink> findAll();
    PanoramaLink getOne(int id);
    Optional<PanoramaLink> findById(int id);
    void delete(PanoramaLink panoramaLink);
    PanoramaLink save(PanoramaLink panoramaLink);
}