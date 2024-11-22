package org.openapitools.services;

import org.openapitools.modelDB.LikeDB;
import org.openapitools.model.Like;
import org.openapitools.repositories.LikeDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeDBService {

	private final LikeDBRepository likeDBRepository;

	@Autowired
	public LikeDBService(LikeDBRepository likeDBRepository) {
		this.likeDBRepository = likeDBRepository;
	}

	// Convert LikeDB entity to Like model
	private Like convertToLike(LikeDB likeDB) {
		Like like = new Like();
		like.setIdDeUsuario(likeDB.getIdDeUsuario());
		like.setIdDeContenido(likeDB.getIdDeContenido());
		return like;
	}

	// Convert Like model to LikeDB entity
	private LikeDB convertToLikeDB(Like like) {
		return new LikeDB(like.getIdDeUsuario(), like.getIdDeContenido());
	}

	// Create a new Like
	public boolean createLike(Like like) {
		try {
			LikeDB likeDB = convertToLikeDB(like);
			likeDBRepository.save(likeDB);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Read (find all likes by user ID)
	public List<Like> findLikesByUserId(Integer idDeUsuario) {
		List<LikeDB> likesDB = likeDBRepository.findByIdDeUsuario(idDeUsuario);
		return likesDB.stream().map(this::convertToLike).collect(Collectors.toList());
	}

	// Read (find all likes by content ID)
	public List<Like> findLikesByContentId(Integer idDeContenido) {
		List<LikeDB> likesDB = likeDBRepository.findByIdDeContenido(idDeContenido);
		return likesDB.stream().map(this::convertToLike).collect(Collectors.toList());
	}

	//Devuelve un Like dadas sus ids o NULL si no lo encuentra.
	public Like findLikeByIds(Integer idDeUsuario, Integer idDeContenido) {
		Optional<LikeDB> likeDB = likeDBRepository.findByIdDeUsuarioAndIdDeContenido(idDeUsuario, idDeContenido);
		if (likeDB.isPresent()) {
			return new Like(likeDB.get());
		} else {
			return null;
		}
	}

	// Delete a like by user and content IDs
	public boolean deleteLikeByIds(Integer idDeUsuario, Integer idDeContenido) {
		Optional<LikeDB> likeDB = likeDBRepository.findByIdDeUsuarioAndIdDeContenido(idDeUsuario, idDeContenido);
		if (likeDB.isPresent()) {
			likeDBRepository.delete(likeDB.get());
			return true;
		}
		return false;
	}

	// Delete all likes by user ID
	public boolean deleteLikesByUserId(Integer idDeUsuario) {
		try {
			likeDBRepository.deleteByIdDeUsuario(idDeUsuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Delete all likes by content ID
	public boolean deleteLikesByContentId(Integer idDeContenido) {
		try {
			likeDBRepository.deleteByIdDeContenido(idDeContenido);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
