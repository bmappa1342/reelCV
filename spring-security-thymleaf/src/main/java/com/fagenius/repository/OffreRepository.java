package com.fagenius.repository;

import com.fagenius.model.Employee;
import com.fagenius.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre, Integer> {
}
