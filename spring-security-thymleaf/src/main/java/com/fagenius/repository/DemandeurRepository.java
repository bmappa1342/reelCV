package com.fagenius.repository;

import com.fagenius.model.Demandeur;
import com.fagenius.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeurRepository extends JpaRepository<Demandeur, Integer> {
}
