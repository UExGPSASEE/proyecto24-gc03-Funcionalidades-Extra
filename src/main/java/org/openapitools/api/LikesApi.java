/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Like;
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
@Tag(name = "Likes", description = "Operaciones relacionadas con los favoritos/likes")
public interface LikesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /likes/cliente/{id_de_usuario} : Devuelve los contenidos que le han gustado a un cliente.
     * Devuelve una lista con los identificadores de los contenidos que han gustado al cliente
     *
     * @param idDeUsuario  (required)
     * @return Contenidos gustados por el cliente devueltos correctamente. (status code 200)
     */
    @Operation(
        operationId = "likesClienteIdDeUsuarioGet",
        summary = "Devuelve los contenidos que le han gustado a un cliente.",
        description = "Devuelve una lista con los identificadores de los contenidos que han gustado al cliente",
        tags = { "Likes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Contenidos gustados por el cliente devueltos correctamente.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Integer.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/likes/cliente/{id_de_usuario}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Integer>> likesClienteIdDeUsuarioGet(
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ 0, 0 ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /likes/contenido/{id_de_contenido} : Devuelve el número de likes de un contenido.
     *
     * @param idDeContenido  (required)
     * @return Número de likes devuelto correctamente. (status code 200)
     */
    @Operation(
        operationId = "likesContenidoIdDeContenidoGet",
        summary = "Devuelve el número de likes de un contenido.",
        tags = { "Likes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Número de likes devuelto correctamente.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/likes/contenido/{id_de_contenido}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Integer> likesContenidoIdDeContenidoGet(
        @Parameter(name = "id_de_contenido", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_contenido") Integer idDeContenido
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /likes/{id_de_contenido}/{id_de_usuario} : Elimina el like del contenido para el usuario especificado.
     *
     * @param idDeContenido  (required)
     * @param idDeUsuario  (required)
     * @return Like eliminado correctamente. (status code 200)
     *         or Contenido o usuario no encontrado. (status code 404)
     */
    @Operation(
        operationId = "likesIdDeContenidoIdDeUsuarioDelete",
        summary = "Elimina el like del contenido para el usuario especificado.",
        tags = { "Likes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Like eliminado correctamente."),
            @ApiResponse(responseCode = "404", description = "Contenido o usuario no encontrado.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/likes/{id_de_contenido}/{id_de_usuario}"
    )
    
    default ResponseEntity<Void> likesIdDeContenidoIdDeUsuarioDelete(
        @Parameter(name = "id_de_contenido", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_contenido") Integer idDeContenido,
        @Parameter(name = "id_de_usuario", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /likes : Añade un like al contenido.
     *
     * @param like  (required)
     * @return Like añadido correctamente. (status code 200)
     *         or Solicitud incorrecta. (status code 400)
     *         or Contenido o usuario no encontrado. (status code 404)
     */
    @Operation(
        operationId = "likesPost",
        summary = "Añade un like al contenido.",
        tags = { "Likes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Like añadido correctamente."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta."),
            @ApiResponse(responseCode = "404", description = "Contenido o usuario no encontrado.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/likes",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> likesPost(
        @Parameter(name = "Like", description = "", required = true) @Valid @RequestBody Like like
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
