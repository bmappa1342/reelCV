package com.fagenius.service;

import com.fagenius.model.Demandeur;
import com.fagenius.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DemandeurService {
    List<Demandeur> getAllDemandeur();
    void saveDemandeur(Demandeur demandeur);
    Demandeur getDemandeurById(int id);
    void deleteDemandeurById(int id);
    Page< Demandeur > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
