package com.fagenius.service;

import com.fagenius.model.Categorie;
import com.fagenius.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public void saveCategorie(Categorie categorie) {
        this.categorieRepository.save(categorie);
    }

    @Override
    public Categorie getCategorieById(int id) {
        Optional< Categorie > optional = categorieRepository.findById(id);
        Categorie categorie = null;
        if (optional.isPresent()) {
            categorie = optional.get();
        } else {
            throw new RuntimeException(" Categorie not found for id :: " + id);
        }
        return categorie;
    }

    @Override
    public void deleteCategorieById(int id) {
        this.categorieRepository.deleteById(id);
    }

    @Override
    public Page<Categorie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.categorieRepository.findAll(pageable);
    }
}
