package com.glassait.lchp.services;

import com.glassait.lchp.model.membre.MembreModel;
import com.glassait.lchp.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;

    public Optional<MembreModel> isClanMember(int accountId) {
        return membreRepository.findById(accountId);
    }
}
