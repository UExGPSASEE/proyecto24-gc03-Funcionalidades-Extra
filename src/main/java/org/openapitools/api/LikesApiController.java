package org.openapitools.api;

import org.openapitools.model.Like;


import org.openapitools.modelDB.LikeDB;
import org.openapitools.services.LikeDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:24.369695700+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.aPIFuncionalidadesExtra.base-path:/StreamHub}")
public class LikesApiController implements LikesApi {

	private final NativeWebRequest request;
	private final LikeDBService likeDBService;

	@Autowired
	public LikesApiController(NativeWebRequest request, LikeDBService likeDBService) {
		this.request = request;
		this.likeDBService = likeDBService;
	}

	public ResponseEntity<List<Integer>> likesClienteIdDeUsuarioGet(Integer idDeUsuario) {
		List<Like> likes = likeDBService.findLikesByUserId(idDeUsuario);
		if (likes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 si el usuario no ha dado like a ningún contenido
		}
		List<Integer> likedContentIds = likes.stream().map(Like::getIdDeContenido).collect(Collectors.toList());
		return ResponseEntity.ok(likedContentIds);  // 200 OK con la lista de IDs de contenido
	}

	public ResponseEntity<Integer> likesContenidoIdDeContenidoGet(Integer idDeContenido) {
		List<Like> likes = likeDBService.findLikesByContentId(idDeContenido);
		return ResponseEntity.ok(likes.size());
	}

	public ResponseEntity<Void> likesPost(Like like) {
		// Añadir el like
		boolean isAdded = likeDBService.createLike(like);
		if (isAdded) {
			return new ResponseEntity<>(HttpStatus.OK);  // 200 OK si el like se añadió correctamente
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // 400 si hay algún problema al añadir el like
		}
	}

	public ResponseEntity<Void> likesIdDeContenidoIdDeUsuarioDelete(Integer idDeContenido, Integer idDeUsuario) {
		if (likeDBService.findLikeByIds(idDeUsuario, idDeContenido) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404 si no existe
		}

		// Eliminar el like
		boolean isDeleted = likeDBService.deleteLikeByIds(idDeUsuario, idDeContenido);

		if (isDeleted) {
			return new ResponseEntity<>(HttpStatus.OK);  // 200 OK si el like se eliminó correctamente
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // 400 si hubo un error al eliminar el like
		}
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

}
