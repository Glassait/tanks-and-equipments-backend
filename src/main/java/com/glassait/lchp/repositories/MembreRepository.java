package com.glassait.lchp.repositories;

import com.glassait.lchp.model.membre.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<MemberModel, Integer> {
}
