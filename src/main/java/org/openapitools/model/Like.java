package org.openapitools.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.modelDB.LikeDB;


import java.util.*;
import javax.annotation.Generated;

/**
 * Like
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:24.369695700+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Like {

	private Integer idDeUsuario;

	private Integer idDeContenido;

	public Like() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public Like(Integer idDeUsuario, Integer idDeContenido) {
		this.idDeUsuario = idDeUsuario;
		this.idDeContenido = idDeContenido;
	}

	public Like(LikeDB likeDB) {
		this.idDeContenido = likeDB.getIdDeContenido();
		this.idDeUsuario = likeDB.getIdDeUsuario();
	}

	public Like idDeUsuario(Integer idDeUsuario) {
		this.idDeUsuario = idDeUsuario;
		return this;
	}

	/**
	 * ID del usuario que da el like.
	 *
	 * @return idDeUsuario
	 */
	@NotNull
	@Schema(name = "id_de_usuario", description = "ID del usuario que da el like.", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("id_de_usuario")
	public Integer getIdDeUsuario() {
		return idDeUsuario;
	}

	public void setIdDeUsuario(Integer idDeUsuario) {
		this.idDeUsuario = idDeUsuario;
	}

	public Like idDeContenido(Integer idDeContenido) {
		this.idDeContenido = idDeContenido;
		return this;
	}

	/**
	 * ID del contenido que recibe el like.
	 *
	 * @return idDeContenido
	 */
	@NotNull
	@Schema(name = "id_de_contenido", description = "ID del contenido que recibe el like.", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("id_de_contenido")
	public Integer getIdDeContenido() {
		return idDeContenido;
	}

	public void setIdDeContenido(Integer idDeContenido) {
		this.idDeContenido = idDeContenido;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Like like = (Like) o;
		return Objects.equals(this.idDeUsuario, like.idDeUsuario) && Objects.equals(this.idDeContenido, like.idDeContenido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDeUsuario, idDeContenido);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Like {\n");
		sb.append("    idDeUsuario: ").append(toIndentedString(idDeUsuario)).append("\n");
		sb.append("    idDeContenido: ").append(toIndentedString(idDeContenido)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

