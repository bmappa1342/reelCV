package com.fagenius.controller;

import com.fagenius.model.Demandeur;
import com.fagenius.model.Employee;
import com.fagenius.service.DemandeurService;
import com.fagenius.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class DemandeurController {

    @Autowired
    private DemandeurService demandeurService;

    // display list of demandeur

    @GetMapping("/showNewDemandeurForm")
    public String showNewDemandeurForm(Model model) {
        // create model attribute to bind form data
        Demandeur demandeur = new Demandeur();
        model.addAttribute("demandeur", demandeur);
        return "Demandeur/new_demandeur";
    }
    @GetMapping("/listDemandeur")
    public String showlistCv(Model model){
        List<Demandeur> ListDemande = demandeurService.getAllDemandeur();
        model.addAttribute("ListDemande",ListDemande);
        return "demandeur/list";
    }

    @GetMapping("/listCv/{id}")
    public String showCv(@PathVariable(value = "id") int id,Model model){
        //List<Demandeur> ListDemande = demandeurService.getAllDemandeur();
        Demandeur ListDemande = demandeurService.getDemandeurById(id);
        model.addAttribute("ListDemande",ListDemande);
        return "demandeur/update_demandeur";
    }

    @PostMapping("/saveDemandeur")
    public String saveDemandeur(@ModelAttribute("demandeur") Demandeur demandeur) {
        // save employee to database
        demandeurService.saveDemandeur(demandeur);
        return "redirect:/showNewDemandeurForm";
    }

    @GetMapping("/showDemandeurUpdate/{id}")
    public String showDemandeurUpdate(@PathVariable(value = "id") int id, Model model) {

        // get cv from the service
        Demandeur demandeur = demandeurService.getDemandeurById(id);

        // set cv as a model attribute to pre-populate the form
        model.addAttribute("demandeur", demandeur);
        return "update_demandeur";
    }

    @GetMapping("/deleteDemandeur/{id}")
    public String deleteDemandeur(@PathVariable(value = "id") int id) {

        // call delete employee method
        this.demandeurService.deleteDemandeurById(id);
        return "redirect:/showNewDemandeurForm";
    }



}
