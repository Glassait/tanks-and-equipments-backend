package com.glassait.equipmentTanks.repositories;

import com.glassait.equipmentTanks.model.membre.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<MemberModel, Integer> {
}
