package org.openapitools.services;

import org.openapitools.model.Lista;
import org.openapitools.modelDB.ListaDB;
import org.openapitools.modelDB.ListaDBId;
import org.openapitools.repositories.ListaDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaDBService {

	private final ListaDBRepository listaDBRepository;

	@Autowired
	public ListaDBService(ListaDBRepository listaDBRepository) {
		this.listaDBRepository = listaDBRepository;
	}

	// función para añadir un contenido a la lista de un usuario
	public boolean addContentToUserList(Integer userId, Integer contentId) {
		ListaDBId listaDBId = new ListaDBId(userId, contentId);
		if (!listaDBRepository.existsById(listaDBId)) {
			listaDBRepository.save(new ListaDB(userId, contentId));
			return true;
		}
		return false; // El contenido ya estaba en la lista
	}

	// función para eliminar un contenido de la lista de un usuario
	public boolean removeContentFromUserList(Integer userId, Integer contentId) {
		ListaDBId listaDBId = new ListaDBId(userId, contentId);
		if (listaDBRepository.existsById(listaDBId)) {
			listaDBRepository.deleteById(listaDBId);
			return true;
		}
		return false; // No existía el contenido en la lista
	}

	@Transactional
	public boolean removeAllContentsFromUserList(Integer idDeUsuario) {
		// Verificar si el usuario tiene contenidos en su lista.
		if (!listaDBRepository.existsByIdUsuario(idDeUsuario)) {
			return false;
		}
		// Eliminar todos los contenidos asociados al usuario
		listaDBRepository.deleteByIdUsuario(idDeUsuario);
		return true;
	}

	public boolean updateUserList(Integer idDeUsuario, List<Integer> contenidoIds) {
		// Verificar si el usuario ya tiene el contenido añadido a su lista
		for (Integer contenidoId : contenidoIds) {
			if (isContentInUserList(idDeUsuario, contenidoId)) {
				return false;
			}
		}

		// Añadir los nuevos contenidos
		for (Integer contenidoId : contenidoIds) {
			ListaDB listaDB = new ListaDB(idDeUsuario, contenidoId);
			listaDBRepository.save(listaDB);
		}

		return true;
	}

	// función para obtener los contenidos en la lista de un usuario
	public Lista getUserList(Integer userId) {
		List<Integer> contentIds = listaDBRepository.findByIdUsuario(userId).stream().map(ListaDB::getIdContenido).collect(Collectors.toList());

		Lista lista = new Lista();
		lista.setContenidos(contentIds);
		return lista;
	}

	// función para verificar si un contenido está en la lista de un usuario
	public boolean isContentInUserList(Integer userId, Integer contentId) {
		ListaDBId listaDBId = new ListaDBId(userId, contentId);
		return listaDBRepository.existsById(listaDBId);
	}
}
