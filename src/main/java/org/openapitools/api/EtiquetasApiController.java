package org.openapitools.api;

import org.openapitools.model.Etiqueta;
import org.openapitools.services.EtiquetaDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.aPIUsuarios.base-path:/StreamHub}")
public class EtiquetasApiController implements EtiquetasApi {
    private final EtiquetaDBService etiquetaDBService;
    private final NativeWebRequest request;

    @Autowired
    public EtiquetasApiController(EtiquetaDBService etiquetaDBService, NativeWebRequest request) {
        this.etiquetaDBService = etiquetaDBService;
        this.request = request;
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
        // Call the service to delete the etiqueta by ID
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
