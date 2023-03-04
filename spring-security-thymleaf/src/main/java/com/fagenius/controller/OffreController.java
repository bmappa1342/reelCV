package com.fagenius.controller;

import com.fagenius.model.Categorie;
import com.fagenius.model.Offre;
import com.fagenius.repository.CategorieRepository;
import com.fagenius.service.CategorieService;
import com.fagenius.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class OffreController {

    @Autowired
    private OffreService offreService;
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategorieRepository categorieRepository;

    // display list

    @GetMapping("/showNewOffreForm")
    public String showNewOffreForm(Model model) {
        // create model attribute to bind form data
        Offre offre = new Offre();
        model.addAttribute("offre", offre);
        return "offre/new_offre";
    }
    @GetMapping("/listOffre")
    public String showlistOffre(Model model){
        List<Offre> ListOffre = offreService.getAllOffre();
        model.addAttribute("ListOffre",ListOffre);
        return "offre/list";
    }

    @PostMapping("/saveOffre")
    public String saveOffre(Model model,@ModelAttribute("offres") Offre offre,@RequestParam Integer idCategorie) {
        // save employee to database
        //model.addAttribute("categories", categorieService.getAllCategorie());
        //Categorie categorie = categorieService.getCategorieById(idCategorie);
        model.addAttribute("categories", categorieRepository.findAll());
        Categorie categorie = categorieRepository.findById(idCategorie).get();
        offre.setCatOffre(categorie);
        offreService.saveOffre(offre);
        return "redirect:/showNewOffreForm";
    }

    @GetMapping("/showOffreUpdate/{id}")
    public String showOffreUpdate(@PathVariable(value = "id") int id, Model model) {

        // get offre from the service
        Offre offre = offreService.getOffreById(id);

        // set offre as a model attribute to pre-populate the form
        model.addAttribute("offre", offre);
        return "update_offre";
    }

    @GetMapping("/deleteOffre/{id}")
    public String deleteOffre(@PathVariable(value = "id") int id) {

        // call delete offre method
        this.offreService.deleteOffreById(id);
        return "redirect:/showNewOffreForm";
    }



}
