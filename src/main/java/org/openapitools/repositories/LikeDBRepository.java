package org.openapitools.repositories;

import org.openapitools.modelDB.LikeDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeDBRepository extends CrudRepository<LikeDB, Integer> {

	// Buscar likes por ID de usuario
	List<LikeDB> findByIdDeUsuario(Integer idDeUsuario);

	// Buscar likes por ID de contenido
	List<LikeDB> findByIdDeContenido(Integer idDeContenido);

	// Buscar un like específico por ID de usuario e ID de contenido
	Optional<LikeDB> findByIdDeUsuarioAndIdDeContenido(Integer idDeUsuario, Integer idDeContenido);

	// Eliminar todos los likes asociados a un usuario
	void deleteByIdDeUsuario(Integer idDeUsuario);

	// Eliminar todos los likes asociados a un contenido
	void deleteByIdDeContenido(Integer idDeContenido);
}
