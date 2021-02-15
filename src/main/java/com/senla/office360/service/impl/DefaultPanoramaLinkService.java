package com.senla.office360.service.impl;

import com.senla.office360.entity.PanoramaLink;
import com.senla.office360.repository.PanoramaLinkRepository;
import com.senla.office360.repository.PanoramaRepository;
import com.senla.office360.service.PanoramaLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultPanoramaLinkService implements PanoramaLinkService {
    private PanoramaLinkRepository panoramaLinkRepository;
    private PanoramaRepository panoramaRepository;

    @Autowired
    public void setPanoramaLinkRepository(PanoramaLinkRepository panoramaLinkRepository) {
        this.panoramaLinkRepository = panoramaLinkRepository;
    }

    @Autowired
    public void setPanoramaRepository(PanoramaRepository panoramaRepository) {
        this.panoramaRepository = panoramaRepository;
    }

    public DefaultPanoramaLinkService() {
    }

    @Override
    public List<PanoramaLink> findAll() {
        List<PanoramaLink> panoramaLinkList = panoramaLinkRepository.findAll();
        List<PanoramaLink> actualPanoramaLinkList = new ArrayList<>();
        for (PanoramaLink link: panoramaLinkList) {
            if (panoramaRepository.findById(link.getPanoramaId()).isPresent() &&
                    panoramaRepository.findById(link.getLinkId()).isPresent()) {
                actualPanoramaLinkList.add(link);
            }
        }
        return actualPanoramaLinkList;
    }

    @Override
    public PanoramaLink getOne(int id) {
        return panoramaLinkRepository.getOne(id);
    }

    @Override
    public Optional<PanoramaLink> findById(int id) {
        return panoramaLinkRepository.findById(id);
    }

    @Override
    public void delete(PanoramaLink panoramaLink) {
        panoramaLinkRepository.delete(panoramaLink);
    }

    @Override
    public PanoramaLink save(PanoramaLink panoramaLink) {
        return panoramaLinkRepository.save(panoramaLink);
    }
}
