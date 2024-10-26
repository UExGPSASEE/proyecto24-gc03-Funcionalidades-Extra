/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.sql.Timestamp;
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
@Tag(name = "Timestamp", description = "Operaciones relacionadas con los timeStamp.")
public interface TimestampApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /timestamp/{id_de_contenido} : Elimina el timestamp de visualización de un contenido.
     *
     * @param idDeContenido  (required)
     * @return Timestamp eliminado correctamente. (status code 200)
     */
    @Operation(
        operationId = "timestampIdDeContenidoDelete",
        summary = "Elimina el timestamp de visualización de un contenido.",
        tags = { "Timestamp" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Timestamp eliminado correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/timestamp/{id_de_contenido}"
    )
    
    default ResponseEntity<Void> timestampIdDeContenidoDelete(
        @Parameter(name = "id_de_contenido", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_contenido") Integer idDeContenido
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /timestamp/{id_de_contenido} : Devuelve el timestamp de visualización de un contenido para un usuario.
     *
     * @param idDeContenido  (required)
     * @return Timestamp devuelto correctamente. (status code 200)
     */
    @Operation(
        operationId = "timestampIdDeContenidoGet",
        summary = "Devuelve el timestamp de visualización de un contenido para un usuario.",
        tags = { "Timestamp" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Timestamp devuelto correctamente.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Timestamp.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/timestamp/{id_de_contenido}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Timestamp> timestampIdDeContenidoGet(
        @Parameter(name = "id_de_contenido", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_contenido") Integer idDeContenido
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id_de_usuario\" : 6, \"id_de_contenido\" : 1, \"segundos\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /timestamp/{id_de_contenido} : Actualiza el timestamp de visualización de un contenido.
     *
     * @param idDeContenido  (required)
     * @param timestamp  (required)
     * @return Timestamp actualizado correctamente. (status code 200)
     */
    @Operation(
        operationId = "timestampIdDeContenidoPut",
        summary = "Actualiza el timestamp de visualización de un contenido.",
        tags = { "Timestamp" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Timestamp actualizado correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/timestamp/{id_de_contenido}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> timestampIdDeContenidoPut(
        @Parameter(name = "id_de_contenido", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_contenido") Integer idDeContenido,
        @Parameter(name = "Timestamp", description = "", required = true) @Valid @RequestBody Timestamp timestamp
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /timestamp : Añade un timestamp para un contenido.
     *
     * @param timestamp  (required)
     * @return Timestamp añadido correctamente. (status code 201)
     */
    @Operation(
        operationId = "timestampPost",
        summary = "Añade un timestamp para un contenido.",
        tags = { "Timestamp" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Timestamp añadido correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/timestamp",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> timestampPost(
        @Parameter(name = "Timestamp", description = "", required = true) @Valid @RequestBody Timestamp timestamp
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
