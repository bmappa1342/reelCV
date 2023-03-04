package com.fagenius.service;

import com.fagenius.model.Categorie;
import com.fagenius.model.Offre;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OffreService {
    List<Offre> getAllOffre();
    void saveOffre(Offre offre);
    Offre getOffreById(int id);
    void deleteOffreById(int id);
    Page< Offre > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
