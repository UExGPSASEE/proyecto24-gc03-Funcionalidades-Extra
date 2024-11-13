package org.openapitools.repositories;

import org.openapitools.modelDB.ListaDB;
import org.openapitools.modelDB.ListaDBId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaDBRepository extends CrudRepository<ListaDB, ListaDBId> {

	// funcion para encontrar todos los contenidos de la lista de un usuario específico
	List<ListaDB> findByIdUsuario(Integer idUsuario);

	// función para eliminar todos los contenidos de la lista de un usuario
	void deleteByIdUsuario(Integer idDeUsuario);

	// función para verificar si un usuario tiene contenidos en la lista
	boolean existsByIdUsuario(Integer idDeUsuario); // Devuelve true si hay algún contenido asociado al usuario
}
