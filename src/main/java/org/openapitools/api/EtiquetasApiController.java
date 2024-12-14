package org.openapitools.api;

import org.openapitools.model.Contenido;
import org.openapitools.model.Etiqueta;
import org.openapitools.services.EtiquetaDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.aPIUsuarios.base-path:/StreamHub}")
public class EtiquetasApiController implements EtiquetasApi {
	private final EtiquetaDBService etiquetaDBService;
	private final NativeWebRequest request;
	private final RestTemplate restTemplate;

	@Autowired
	public EtiquetasApiController(EtiquetaDBService etiquetaDBService, NativeWebRequest request, RestTemplate restTemplate) {
		this.etiquetaDBService = etiquetaDBService;
		this.request = request;
		this.restTemplate = restTemplate;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<List<Etiqueta>> etiquetasGet() {
		List<Etiqueta> etiquetas = etiquetaDBService.findAllEtiquetas();
		return ResponseEntity.ok(etiquetas);
	}

	@Override
	public ResponseEntity<Etiqueta> etiquetasIdDeEtiquetaGet(Integer id) {
		Optional<Etiqueta> etiquetaOptional = etiquetaDBService.findEtiquetaById(id);

		// Return 200 with the Etiqueta data
		// Return 404 if not found
		return etiquetaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Void> etiquetasPost(Etiqueta etiqueta) {
		// Call the service to save the new Etiqueta
		boolean isCreated = etiquetaDBService.createEtiqueta(etiqueta);

		if (isCreated) {
			// Return 201 Created response
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			// Handle cases where creation failed (e.g., due to validation)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Override
	public ResponseEntity<Void> etiquetasIdDeEtiquetaDelete(Integer id) {
		// Obtener la lista de contenidos asociados a esta etiqueta usando el endpoint /contenidos/etiquetas
		String url = "http://contenidos:8080/StreamHub/contenidos/etiquetas";
		ResponseEntity<List<Contenido>> responseEntity = restTemplate.exchange(UriComponentsBuilder.fromHttpUrl(url).queryParam("etiquetas", id).build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Contenido>>() {
		});

		List<Contenido> contenidos = responseEntity.getBody(); // Obtener los contenidos de la respuesta

		// Actualizar los contenidos para eliminar la etiqueta
		if (contenidos != null) {
			for (Contenido contenido : contenidos) {
				List<Integer> etiquetaIds = new ArrayList<>(contenido.getEtiquetaIds()); // Copiar la lista de etiquetas
				etiquetaIds.remove(id); // Eliminar la etiqueta que se va a eliminar

				// Crear un nuevo objeto Contenido con la lista de etiquetas actualizada
				Contenido contenidoActualizado = new Contenido(contenido.getId(), contenido.getTipo(), contenido.getTitulo(), contenido.getProductionYear(), contenido.getClasificacionEdad(), contenido.getDescripcion(), contenido.getPerteneceA(), contenido.getNumeroElementos(), contenido.getDuracion(), contenido.getUrl(), etiquetaIds);

				// Realizar la llamada a la API de contenidos para actualizar
				String contenidoApiUrl = String.format("http://localhost:8081/StreamHub/contenidos/%d", contenido.getId());
				restTemplate.put(contenidoApiUrl, contenidoActualizado);
			}
		}

		// Llamar al servicio para eliminar la etiqueta
		boolean isDeleted = etiquetaDBService.deleteEtiquetaById(id);

		if (isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
		}
	}


	@Override
	public ResponseEntity<Void> etiquetasIdDeEtiquetaPut(Integer id, Etiqueta etiqueta) {
		// Call the service to update the etiqueta
		boolean isUpdated = etiquetaDBService.updateEtiqueta(id, etiqueta);

		if (isUpdated) {
			return new ResponseEntity<>(HttpStatus.OK); // 200 OK
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
		}
	}
}
