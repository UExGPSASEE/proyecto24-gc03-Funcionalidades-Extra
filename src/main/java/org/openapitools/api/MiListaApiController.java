package org.openapitools.api;

import org.openapitools.model.Lista;


import org.openapitools.services.ListaDBService;
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
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:24.369695700+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.aPIFuncionalidadesExtra.base-path:/StreamHub}")
public class MiListaApiController implements MiListaApi {
	private final ListaDBService listaDBService;
	private final NativeWebRequest request;

	@Autowired
	public MiListaApiController(ListaDBService listaDBService, NativeWebRequest request) {
		this.listaDBService = listaDBService;
		this.request = request;
	}

	@Override
	public ResponseEntity<Lista> miListaIdDeUsuarioGet(Integer idDeUsuario) {
		// Llama al servicio para obtener la lista de contenidos del usuario
		Lista lista = listaDBService.getUserList(idDeUsuario);

		/* En principio no lo ponemos porque consideramos que una lista vacía también es válida.
		if (lista.getContenidos().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si no hay contenidos
		}
		*/
		return ResponseEntity.ok(lista); // 200 OK con la lista de contenidos
	}

	@Override
	public ResponseEntity<Void> miListaIdDeUsuarioPut(Integer idDeUsuario, Lista lista) {
		// Obtener los contenidos de la lista que se desean actualizar
		List<Integer> contenidoIds = lista.getContenidos();

		if (contenidoIds == null || contenidoIds.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 si la lista está vacía o inválida
		}

		// Llamar al servicio para actualizar la lista de contenidos del usuario
		boolean isUpdated = listaDBService.updateUserList(idDeUsuario, contenidoIds);

		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.OK); // 200 OK si la lista se actualiza correctamente
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 si el usuario ya tenía el contenido en la lista
		}
	}

	@Override
	public ResponseEntity<Void> miListaIdDeUsuarioIdDeContenidoDelete(Integer idDeUsuario, Integer idDeContenido) {

		// Intentar eliminar el contenido de la lista del usuario
		boolean isDeleted = listaDBService.removeContentFromUserList(idDeUsuario, idDeContenido);

		if (isDeleted) {
			return ResponseEntity.ok().build(); // 200 OK si se eliminó correctamente
		} else {
			return ResponseEntity.notFound().build(); // 404 si el usuario o el contenido no se encuentran
		}
	}

	@Override
	public ResponseEntity<Void> miListaIdDeUsuarioDelete(Integer idDeUsuario) {

		// Intentamos eliminar todos los contenidos de la lista del usuario
		boolean isDeleted = listaDBService.removeAllContentsFromUserList(idDeUsuario);

		if (isDeleted) {
			return ResponseEntity.ok().build(); // 200 OK si se eliminaron los contenidos correctamente
		} else {
			return ResponseEntity.notFound().build(); // 404 si el usuario no existe o no tiene contenidos
		}
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

}
