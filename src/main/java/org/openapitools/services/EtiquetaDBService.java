package org.openapitools.services;

import org.openapitools.model.Etiqueta;
import org.openapitools.modelDB.EtiquetaDB;
import org.openapitools.repositories.EtiquetasDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtiquetaDBService {

    private final EtiquetasDBRepository EtiquetasDBRepository;

    @Autowired
    public EtiquetaDBService(EtiquetasDBRepository EtiquetasDBRepository) {
        this.EtiquetasDBRepository = EtiquetasDBRepository;
    }

    private Etiqueta convertToEtiqueta(EtiquetaDB etiquetaDB) {
        return new Etiqueta(etiquetaDB);
    }

    // Create a new Etiqueta
    public boolean createEtiqueta(Etiqueta etiqueta) {
        try {
            // Convert Etiqueta to EtiquetaDB
            EtiquetaDB etiquetaDB = new EtiquetaDB(etiqueta);
            // Save the EtiquetaDB entity
            EtiquetasDBRepository.save(etiquetaDB);
            return true; // Indicate success
        } catch (Exception e) {
            // Log exception if needed
            return false; // Indicate failure
        }
    }

    // Update an existing Etiqueta
    public boolean updateEtiqueta(Integer id, Etiqueta etiqueta) {
        Optional<EtiquetaDB> existingEtiqueta = EtiquetasDBRepository.findById(id);
        if (existingEtiqueta.isPresent()) {
            EtiquetaDB updatedEtiquetaDB = existingEtiqueta.get();
            updatedEtiquetaDB.setNombre(etiqueta.getNombre());
            // Save the updated EtiquetaDB
            EtiquetasDBRepository.save(updatedEtiquetaDB);
            return true; // Indicate successful update
        }
        return false; // Indicate that the Etiqueta was not found
    }

    // Read (find by ID)
    public Optional<Etiqueta> findEtiquetaById(Integer id) {
        Optional<EtiquetaDB> etiquetaDBOptional = EtiquetasDBRepository.findById(id);
        return etiquetaDBOptional.map(this::convertToEtiqueta); // Convert if present
    }

    // Read (find all)
    public List<Etiqueta> findAllEtiquetas() {
        List<EtiquetaDB> etiquetaDBs = (List<EtiquetaDB>) EtiquetasDBRepository.findAll();
        return etiquetaDBs.stream().map(this::convertToEtiqueta) // Convert each EtiquetaDB to Etiqueta
                .collect(Collectors.toList());
    }

    // Delete by ID
    public boolean deleteEtiquetaById(Integer id) {
        Optional<EtiquetaDB> etiqueta = EtiquetasDBRepository.findById(id);
        if (etiqueta.isPresent()) {
            EtiquetasDBRepository.deleteById(id); // Delete the EtiquetaDB from the repository
            return true; // Indicate successful deletion
        }
        return false; // Indicate that the Etiqueta was not found
    }

}
