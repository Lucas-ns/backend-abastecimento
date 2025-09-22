package com.dimensionalengenharia.backend.services;

import com.dimensionalengenharia.backend.exceptions.ResourceNotFoundException;
import com.dimensionalengenharia.backend.models.Obra;
import com.dimensionalengenharia.backend.repositories.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> getObras() {
        return obraRepository.findAll();
    }

    public Obra getObraById(String id) {
        return obraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Obra com ID " + id + " não encontrada"));
    }

    public void createObra(Obra obra) {
        obraRepository.save(obra);
    }

    public void deleteObra(String id) {
        Obra obra = obraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Obra com ID " + id + " não encontrada"));
        obraRepository.delete(obra);
    }
}
