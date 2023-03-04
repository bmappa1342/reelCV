package com.fagenius.service;

import com.fagenius.model.Categorie;
import com.fagenius.model.Demandeur;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategorie();
    void saveCategorie(Categorie categorie);
    Categorie getCategorieById(int id);
    void deleteCategorieById(int id);
    Page< Categorie > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
