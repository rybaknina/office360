package com.senla.office360.controller;

import com.senla.office360.entity.PanoramaLink;
import com.senla.office360.service.PanoramaLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PanoramaLinkController {
    private PanoramaLinkService panoramaLinkService;

    @Autowired
    public void setPanoramaLinkService(PanoramaLinkService panoramaLinkService) {
        this.panoramaLinkService = panoramaLinkService;
    }

    @GetMapping("/showlink")
    public String showLinkForm(PanoramaLink panoramaLink) {
        return "add-link";
    }

    @PostMapping("/addlink")
    public String addLink(PanoramaLink panoramaLink, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-link";
        }
        panoramaLinkService.save(panoramaLink);
        return "redirect:/links";
    }

    @GetMapping("/editlink/{id}")
    public String showUpdateLinkForm(@PathVariable("id") int id, Model model) {
        PanoramaLink panoramaLink = panoramaLinkService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid link Id:" + id));
        model.addAttribute("link", panoramaLink);

        return "update-link";
    }

    @PostMapping("/updatelink/{id}")
    public String updateLink(@PathVariable("id") int id, PanoramaLink panoramaLink, BindingResult result, Model model) {
        if (result.hasErrors()) {
            panoramaLink.setId(id);
            return "update-link";
        }

        panoramaLinkService.save(panoramaLink);

        return "redirect:/links";
    }

    @GetMapping("/deletelink/{id}")
    public String deleteLink(@PathVariable("id") int id, Model model) {
        PanoramaLink panoramaLink = panoramaLinkService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid link Id:" + id));
        panoramaLinkService.delete(panoramaLink);

        return "redirect:/links";
    }
    @GetMapping("/links")
    public String showLinkList(Model model) {
        model.addAttribute("linkList", panoramaLinkService.findAll());
        return "links";
    }
}
