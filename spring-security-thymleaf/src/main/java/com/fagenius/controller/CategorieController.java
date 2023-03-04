package com.fagenius.controller;

import com.fagenius.model.Categorie;
import com.fagenius.model.Demandeur;
import com.fagenius.repository.CategorieRepository;
import com.fagenius.service.CategorieService;
import com.fagenius.service.DemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // display list

    @GetMapping("/showNewCategorieForm")
    public String showNewCategorieForm(Model model) {
        // create model attribute to bind form data
        Categorie  categorie = new Categorie();
        model.addAttribute("categorie", categorie);
        return "categorie/new_categorie";
    }
    @GetMapping("/listCategorie")
    public String showlistCategorie(Model model){
        List<Categorie> ListCategorie = categorieService.getAllCategorie();
        model.addAttribute("ListCategorie",ListCategorie);
        return "categorie/list";
    }

    @PostMapping("/saveCategorie")
    public String saveCategorie(@ModelAttribute("categorie") Categorie categorie) {
        // save employee to database
        categorieService.saveCategorie(categorie);
        return "redirect:/showNewCategorieForm";
    }

    @GetMapping("/showCategorieUpdate/{id}")
    public String showCategorieUpdate(@PathVariable(value = "id") int id, Model model) {

        // get employee from the service
        Categorie categorie = categorieService.getCategorieById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("categorie", categorie);
        return "update_categorie";
    }

    @GetMapping("/deleteCategorie/{id}")
    public String deleteCategorie(@PathVariable(value = "id") int id) {

        // call delete employee method
        this.categorieService.deleteCategorieById(id);
        return "redirect:/showNewCategorieForm";
    }



}
