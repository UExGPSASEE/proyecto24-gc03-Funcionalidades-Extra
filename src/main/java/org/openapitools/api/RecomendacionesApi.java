/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Recomendaciones;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:24.369695700+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "Recomendaciones", description = "Operaciones relacionadas con las recomendaciones")
public interface RecomendacionesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /recomendaciones/{id_de_usuario} : Elimina recomendaciones para un usuario.
     *
     * @param idDeUsuario  (required)
     * @return Recomendaciones eliminadas correctamente. (status code 200)
     */
    @Operation(
        operationId = "recomendacionesIdDeUsuarioDelete",
        summary = "Elimina recomendaciones para un usuario.",
        tags = { "Recomendaciones" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Recomendaciones eliminadas correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/recomendaciones/{id_de_usuario}"
    )
    
    default ResponseEntity<Void> recomendacionesIdDeUsuarioDelete(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /recomendaciones/{id_de_usuario} : Devuelve las recomendaciones para un usuario.
     *
     * @param idDeUsuario  (required)
     * @return Recomendaciones del usuario devueltas correctamente. (status code 200)
     */
    @Operation(
        operationId = "recomendacionesIdDeUsuarioGet",
        summary = "Devuelve las recomendaciones para un usuario.",
        tags = { "Recomendaciones" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Recomendaciones del usuario devueltas correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/recomendaciones/{id_de_usuario}"
    )
    
    default ResponseEntity<Void> recomendacionesIdDeUsuarioGet(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /recomendaciones/{id_de_usuario} : Añade recomendaciones para un usuario.
     *
     * @param idDeUsuario  (required)
     * @param recomendaciones  (required)
     * @return Recomendaciones añadidas correctamente. (status code 200)
     */
    @Operation(
        operationId = "recomendacionesIdDeUsuarioPut",
        summary = "Añade recomendaciones para un usuario.",
        tags = { "Recomendaciones" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Recomendaciones añadidas correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/recomendaciones/{id_de_usuario}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> recomendacionesIdDeUsuarioPut(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario,
        @Parameter(name = "Recomendaciones", description = "", required = true) @Valid @RequestBody Recomendaciones recomendaciones
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
