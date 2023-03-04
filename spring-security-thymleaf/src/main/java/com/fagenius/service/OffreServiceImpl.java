package com.fagenius.service;

import com.fagenius.model.Categorie;
import com.fagenius.model.Offre;
import com.fagenius.repository.CategorieRepository;
import com.fagenius.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreServiceImpl implements OffreService {

    @Autowired
    private OffreRepository offreRepository;

    @Override
    public List<Offre> getAllOffre() {
        return offreRepository.findAll();
    }

    @Override
    public void saveOffre(Offre offre) {
        this.offreRepository.save(offre);
    }

    @Override
    public Offre getOffreById(int id) {
        Optional< Offre > optional = offreRepository.findById(id);
        Offre offre = null;
        if (optional.isPresent()) {
            offre = optional.get();
        } else {
            throw new RuntimeException(" Offre not found for id :: " + id);
        }
        return offre;
    }

    @Override
    public void deleteOffreById(int id) {
        this.offreRepository.deleteById(id);
    }

    @Override
    public Page<Offre> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.offreRepository.findAll(pageable);
    }
}
