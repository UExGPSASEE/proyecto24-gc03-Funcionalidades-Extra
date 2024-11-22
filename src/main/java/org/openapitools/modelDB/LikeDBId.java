// LikeDBId.java
package org.openapitools.modelDB;

import java.io.Serializable;
import java.util.Objects;

public class LikeDBId implements Serializable {
	private Integer idDeUsuario;
	private Integer idDeContenido;

	// Constructor sin parámetros
	public LikeDBId() {
	}

	// Constructor con parámetros
	public LikeDBId(Integer idDeUsuario, Integer idDeContenido) {
		this.idDeUsuario = idDeUsuario;
		this.idDeContenido = idDeContenido;
	}

	// Getters y setters
	public Integer getIdDeUsuario() {
		return idDeUsuario;
	}

	public void setIdDeUsuario(Integer idDeUsuario) {
		this.idDeUsuario = idDeUsuario;
	}

	public Integer getIdDeContenido() {
		return idDeContenido;
	}

	public void setIdDeContenido(Integer idDeContenido) {
		this.idDeContenido = idDeContenido;
	}

	// Implementa equals y hashCode
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LikeDBId that = (LikeDBId) o;
		return Objects.equals(idDeUsuario, that.idDeUsuario) && Objects.equals(idDeContenido, that.idDeContenido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDeUsuario, idDeContenido);
	}
}
