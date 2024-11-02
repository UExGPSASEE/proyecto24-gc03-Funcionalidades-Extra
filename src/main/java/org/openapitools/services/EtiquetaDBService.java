package org.openapitools.services;

import org.openapitools.model.Etiqueta;
import org.openapitools.modelDB.EtiquetaDB;
import org.openapitools.repositories.EtiquetasDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaDBService {
    private final EtiquetasDBRepository etiquetasDBRepository;

    @Autowired
    public EtiquetaDBService(EtiquetasDBRepository EtiquetasDBRepository) {
        this.etiquetasDBRepository = EtiquetasDBRepository;
    }

    private Etiqueta convertToEtiqueta(EtiquetaDB etiquetaDB) {
        return new Etiqueta(etiquetaDB);
    }


}


