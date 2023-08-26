package com.glassait.lchp.repositories;

import com.glassait.lchp.model.membre.MembreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<MembreModel, Integer> {
}
