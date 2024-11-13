package org.openapitools.modelDB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "mi_lista")
@IdClass(ListaDBId.class)
public class ListaDB implements Serializable {

	@Id
	@Column(name = "id_usuario", nullable = false)
	private Integer idUsuario;

	@Id
	@Column(name = "id_contenido", nullable = false)
	private Integer idContenido;

	// Constructor vacío
	public ListaDB() {}

	// Constructor con parámetros
	public ListaDB(Integer idUsuario, Integer idContenido) {
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
		ListaDB listaDB = (ListaDB) o;
		return Objects.equals(idUsuario, listaDB.idUsuario) && Objects.equals(idContenido, listaDB.idContenido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, idContenido);
	}
}
