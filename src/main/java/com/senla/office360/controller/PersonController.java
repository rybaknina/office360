package com.senla.office360.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.office360.entity.Panorama;
import com.senla.office360.entity.PanoramaLink;
import com.senla.office360.entity.Person;
import com.senla.office360.service.PanoramaLinkService;
import com.senla.office360.service.PanoramaService;
import com.senla.office360.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {
    private PersonService personService;
    private PanoramaService panoramaService;
    private PanoramaLinkService panoramaLinkService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setPanoramaService(PanoramaService panoramaService) {
        this.panoramaService = panoramaService;
    }

    @Autowired
    public void setPanoramaLinkService(PanoramaLinkService panoramaLinkService) {
        this.panoramaLinkService = panoramaLinkService;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Person person) {
        return "add-person";
    }

    @PostMapping("/addperson")
    public String addPerson(Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-person";
        }
        Panorama panorama = panoramaService.getOne(person.getPanorama().getId());
        if (panorama != null) {
            person.setPanorama(panorama);
        }
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Person person = personService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);

        return "update-person";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") int id, Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            person.setId(id);
            return "update-person";
        }
        Panorama panorama = panoramaService.getOne(person.getPanorama().getId());
        person.setPanorama(panorama);

        personService.save(person);

        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        Person person = personService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        personService.delete(person);

        return "redirect:/persons";
    }
    @GetMapping("/persons")
    public String showPersonList(Model model) {
        model.addAttribute("personList", personService.findAll());
        return "persons";
    }

    @GetMapping("/office360")
    public String office360(Model model) throws JsonProcessingException {
        List<Person> personList = personService.findAll();
        model.addAttribute("persons", personList);
        List<Panorama> panoramaList = panoramaService.findAll();
        model.addAttribute("panoramas", panoramaList);
        List<PanoramaLink> panoramaLinkList = panoramaLinkService.findAll();
        model.addAttribute("panoramaLinks", panoramaLinkList);
        return "office360";
    }

    @GetMapping("/plan")
    public String plan(Model model) {
        // user LeafletPano for tiles image and copy to /image/plan directory
        return "plan";
    }
}
