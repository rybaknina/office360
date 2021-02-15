package com.senla.office360.service;

import com.senla.office360.entity.Panorama;

import java.util.List;
import java.util.Optional;

public interface PanoramaService {
    List<Panorama> findAll();
    Panorama getOne(int id);
    Optional<Panorama> findById(int id);
    void delete(Panorama panorama);
    Panorama save(Panorama panorama);
}
