package com.fagenius.service;

import com.fagenius.model.Demandeur;
import com.fagenius.model.Employee;
import com.fagenius.repository.DemandeurRepository;
import com.fagenius.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeurServiceImpl implements DemandeurService {

    @Autowired
    private DemandeurRepository demandeurRepository;

    @Override
    public List<Demandeur> getAllDemandeur() {
        return demandeurRepository.findAll();
    }

    @Override
    public void saveDemandeur(Demandeur demandeur) {
        this.demandeurRepository.save(demandeur);
    }

    @Override
    public Demandeur getDemandeurById(int id) {
        Optional< Demandeur > optional = demandeurRepository.findById(id);
        Demandeur demandeur = null;
        if (optional.isPresent()) {
            demandeur = optional.get();
        } else {
            throw new RuntimeException(" Demandeur not found for id :: " + id);
        }
        return demandeur;
    }

    @Override
    public void deleteDemandeurById(int id) {
        this.demandeurRepository.deleteById(id);
    }

    @Override
    public Page<Demandeur> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.demandeurRepository.findAll(pageable);
    }
}
