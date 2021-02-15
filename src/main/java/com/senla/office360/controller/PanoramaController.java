package com.senla.office360.controller;

import com.senla.office360.entity.Panorama;
import com.senla.office360.service.PanoramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/panoramas")
public class PanoramaController {
    private PanoramaService panoramaService;

    @Autowired
    public void setPanoramaService(PanoramaService panoramaService) {
        this.panoramaService = panoramaService;
    }
    @GetMapping("/panorama")
    public String showPanoramaForm(Panorama panorama) {
        return "add-panorama";
    }

    @PostMapping("/addpanorama")
    public String addPanorama(Panorama panorama, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-panorama";
        }
        panoramaService.save(panorama);
        return "redirect:/panoramas";
    }

    @GetMapping("/editpanorama/{id}")
    public String showUpdatePanoramaForm(@PathVariable("id") int id, Model model) {
        Panorama panorama = panoramaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid panorama Id:" + id));
        model.addAttribute("panorama", panorama);

        return "update-panorama";
    }

    @PostMapping("/updatepanorama/{id}")
    public String updatePanorama(@PathVariable("id") int id, Panorama panorama, BindingResult result, Model model) {
        if (result.hasErrors()) {
            panorama.setId(id);
            return "update-panorama";
        }

        panoramaService.save(panorama);

        return "redirect:/panoramas";
    }

    @GetMapping("/deletepanorama/{id}")
    public String deletePanorama(@PathVariable("id") int id, Model model) {
        Panorama panorama = panoramaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid panorama Id:" + id));
        panoramaService.delete(panorama);

        return "redirect:/panoramas";
    }
    @GetMapping("/panoramas")
    public String showPanoramaList(Model model) {
        model.addAttribute("panoramaList", panoramaService.findAll());
        return "panoramas";
    }
}
