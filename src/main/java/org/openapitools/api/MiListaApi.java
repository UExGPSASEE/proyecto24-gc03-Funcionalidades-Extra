/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Lista;
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
@Tag(name = "MiLista", description = "Operaciones relacionadas mi lista.")
public interface MiListaApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /miLista/{id_de_usuario} : Elimina todos los contenidos de la lista del usuario.
     *
     * @param idDeUsuario  (required)
     * @return Contenidos eliminados de la lista correctamente. (status code 200)
     */
    @Operation(
        operationId = "miListaIdDeUsuarioDelete",
        summary = "Elimina todos los contenidos de la lista del usuario.",
        tags = { "MiLista" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Contenidos eliminados de la lista correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/miLista/{id_de_usuario}"
    )
    
    default ResponseEntity<Void> miListaIdDeUsuarioDelete(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /miLista/{id_de_usuario} : Devuelve los detalles de la lista del cliente dado.
     *
     * @param idDeUsuario  (required)
     * @return Lista del cliente devuelta correctamente. (status code 200)
     */
    @Operation(
        operationId = "miListaIdDeUsuarioGet",
        summary = "Devuelve los detalles de la lista del cliente dado.",
        tags = { "MiLista" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista del cliente devuelta correctamente.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Lista.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/miLista/{id_de_usuario}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Lista> miListaIdDeUsuarioGet(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"contenidos\" : [ 0, 0 ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /miLista/{id_de_usuario}/{id_de_contenido} : Elimina un contenido concreto de la lista del usuario.
     *
     * @param idDeUsuario  (required)
     * @param idDeContenido  (required)
     * @return Contenidos eliminados de la lista correctamente. (status code 200)
     */
    @Operation(
        operationId = "miListaIdDeUsuarioIdDeContenidoDelete",
        summary = "Elimina un contenido concreto de la lista del usuario.",
        tags = { "MiLista" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Contenidos eliminados de la lista correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/miLista/{id_de_usuario}/{id_de_contenido}"
    )
    
    default ResponseEntity<Void> miListaIdDeUsuarioIdDeContenidoDelete(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario,
        @Parameter(name = "id_de_contenido", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_contenido") Integer idDeContenido
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /miLista/{id_de_usuario} : Actualiza los contenidos de la lista del usuario.
     * Se envía un array que contiene los id de los contenidos que se desean añadir a la lista del usuario especificado en el parámetro.
     *
     * @param idDeUsuario  (required)
     * @param lista  (required)
     * @return Lista actualizada correctamente. (status code 200)
     */
    @Operation(
        operationId = "miListaIdDeUsuarioPut",
        summary = "Actualiza los contenidos de la lista del usuario.",
        description = "Se envía un array que contiene los id de los contenidos que se desean añadir a la lista del usuario especificado en el parámetro.",
        tags = { "MiLista" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista actualizada correctamente.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/miLista/{id_de_usuario}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> miListaIdDeUsuarioPut(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario,
        @Parameter(name = "Lista", description = "", required = true) @Valid @RequestBody Lista lista
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
