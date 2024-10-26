package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Lista
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:24.369695700+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Lista {

  @Valid
  private List<Integer> contenidos = new ArrayList<>();

  public Lista() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Lista(List<Integer> contenidos) {
    this.contenidos = contenidos;
  }

  public Lista contenidos(List<Integer> contenidos) {
    this.contenidos = contenidos;
    return this;
  }

  public Lista addContenidosItem(Integer contenidosItem) {
    if (this.contenidos == null) {
      this.contenidos = new ArrayList<>();
    }
    this.contenidos.add(contenidosItem);
    return this;
  }

  /**
   * IDs de los contenidos en la lista.
   * @return contenidos
   */
  @NotNull 
  @Schema(name = "contenidos", description = "IDs de los contenidos en la lista.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contenidos")
  public List<Integer> getContenidos() {
    return contenidos;
  }

  public void setContenidos(List<Integer> contenidos) {
    this.contenidos = contenidos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lista lista = (Lista) o;
    return Objects.equals(this.contenidos, lista.contenidos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contenidos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lista {\n");
    sb.append("    contenidos: ").append(toIndentedString(contenidos)).append("\n");
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

