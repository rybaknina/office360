package com.senla.office360.service.impl;

import com.senla.office360.entity.Panorama;
import com.senla.office360.repository.PanoramaRepository;
import com.senla.office360.service.PanoramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultPanoramaService implements PanoramaService {
    private PanoramaRepository panoramaRepository;

    @Autowired
    public void setPanoramaRepository(PanoramaRepository panoramaRepository) {
        this.panoramaRepository = panoramaRepository;
    }

    public DefaultPanoramaService() {
    }

    @Override
    public List<Panorama> findAll() {
        return panoramaRepository.findAll();
    }

    @Override
    public Panorama getOne(int id) {
        return panoramaRepository.getOne(id);
    }

    @Override
    public Optional<Panorama> findById(int id) {
        return panoramaRepository.findById(id);
    }

    @Override
    public void delete(Panorama panorama) {
        panoramaRepository.delete(panorama);
    }

    @Override
    public Panorama save(Panorama panorama) {
        return panoramaRepository.save(panorama);
    }
}
