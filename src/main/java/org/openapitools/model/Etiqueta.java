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
import org.openapitools.modelDB.EtiquetaDB;


import java.util.*;
import javax.annotation.Generated;

/**
 * Etiqueta
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:24.369695700+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Etiqueta {

  private String nombre;

  private Integer idEtiqueta;

  public Etiqueta() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Etiqueta(String nombre, Integer idEtiqueta) {
    this.nombre = nombre;
    this.idEtiqueta = idEtiqueta;
  }

  public Etiqueta nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  public Etiqueta(EtiquetaDB etiquetaDB) {
    this.nombre = etiquetaDB.getNombre();
    this.idEtiqueta = etiquetaDB.getId();
  }

  /**
   * Nombre de la etiqueta
   * @return nombre
   */
  @NotNull 
  @Schema(name = "nombre", description = "Nombre de la etiqueta", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Etiqueta idEtiqueta(Integer idEtiqueta) {
    this.idEtiqueta = idEtiqueta;
    return this;
  }

  /**
   * Identificador de la etiqueta
   * @return idEtiqueta
   */
  @NotNull 
  @Schema(name = "id_etiqueta", description = "Identificador de la etiqueta", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id_etiqueta")
  public Integer getIdEtiqueta() {
    return idEtiqueta;
  }

  public void setIdEtiqueta(Integer idEtiqueta) {
    this.idEtiqueta = idEtiqueta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Etiqueta etiqueta = (Etiqueta) o;
    return Objects.equals(this.nombre, etiqueta.nombre) &&
        Objects.equals(this.idEtiqueta, etiqueta.idEtiqueta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, idEtiqueta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Etiqueta {\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    idEtiqueta: ").append(toIndentedString(idEtiqueta)).append("\n");
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

