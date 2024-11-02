package org.openapitools.repositories;

import org.openapitools.modelDB.EtiquetaDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetasDBRepository extends CrudRepository<EtiquetaDB, Integer> {
    EtiquetaDB findById(int id);
}