package org.openapitools.modelDB;

import java.io.Serializable;
import java.util.Objects;

public class ListaDBId implements Serializable {

	private Integer idUsuario;
	private Integer idContenido;

	// Constructor vacío
	public ListaDBId() {}

	// Constructor con parámetros
	public ListaDBId(Integer idUsuario, Integer idContenido) {
		this.idUsuario = idUsuario;
		this.idContenido = idContenido;
	}

	// Getters y setters
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(Integer idContenido) {
		this.idContenido = idContenido;
	}

	// Métodos equals y hashCode para la clave compuesta
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListaDBId listaDBId = (ListaDBId) o;
		return Objects.equals(idUsuario, listaDBId.idUsuario) && Objects.equals(idContenido, listaDBId.idContenido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, idContenido);
	}
}
