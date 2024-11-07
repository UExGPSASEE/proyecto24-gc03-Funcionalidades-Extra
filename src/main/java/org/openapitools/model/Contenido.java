package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.modelDB.ContenidoDB;

import javax.annotation.Generated;
import java.util.List;
import java.util.Objects;

/**
 * Contenido
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T20:23:40.033986300+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Contenido {

	private Integer id;

	/**
	 * Gets or Sets tipo
	 */
	public enum TipoEnum {
		PELICULA("Pelicula"),

		SERIE("Serie"),

		TEMPORADA("Temporada"),

		EPISODIO("Episodio"),

		DOCUMENTAL("Documental"),

		CORTO("Corto");

		private String value;

		TipoEnum(String value) {
			this.value = value;
		}

		@JsonValue
		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TipoEnum fromValue(String value) {
			for (TipoEnum b : TipoEnum.values()) {
				if (b.value.equals(value)) {
					return b;
				}
			}
			throw new IllegalArgumentException("Unexpected value '" + value + "'");
		}
	}

	private TipoEnum tipo;

	private String titulo;

	private Integer productionYear;

	private String clasificacionEdad;

	private String descripcion;

	private Integer perteneceA;

	private Integer numeroElementos;

	private Integer duracion;

	private String url;
	private List<Integer> etiquetaIds;

	public Contenido() {
		//Empty constructor
	}

	public Contenido id(Integer id) {
		this.id = id;
		return this;
	}

	public Contenido(Integer id, TipoEnum tipo, String titulo, Integer productionYear, String clasificacionEdad, String descripcion, Integer perteneceA, Integer numeroElementos, Integer duracion, String url, List<Integer> etiquetaIds) {
		this.id = id;
		this.tipo = tipo;
		this.titulo = titulo;
		this.productionYear = productionYear;
		this.clasificacionEdad = clasificacionEdad;
		this.descripcion = descripcion;
		this.perteneceA = perteneceA;
		this.numeroElementos = numeroElementos;
		this.duracion = duracion;
		this.url = url;
		this.etiquetaIds = etiquetaIds;
	}

	public Contenido(ContenidoDB contenidoDB) {
		this.id = contenidoDB.getId();
		this.tipo = TipoEnum.fromValue(contenidoDB.getTipo());
		this.titulo = contenidoDB.getTitulo();
		this.productionYear = contenidoDB.getProductionYear();
		this.clasificacionEdad = contenidoDB.getClasificacionEdad();
		this.descripcion = contenidoDB.getDescripcion();
		this.perteneceA = contenidoDB.getPerteneceA();
		this.numeroElementos = contenidoDB.getNumeroElementos();
		this.duracion = contenidoDB.getDuracion();
		this.url = contenidoDB.getUrl();
		this.etiquetaIds = contenidoDB.getEtiquetaIds();
	}

	/**
	 * Get id
	 *
	 * @return id
	 */

	@Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Contenido tipo(TipoEnum tipo) {
		this.tipo = tipo;
		return this;
	}

	/**
	 * Get tipo
	 *
	 * @return tipo
	 */

	@Schema(name = "tipo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("tipo")
	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public Contenido titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	/**
	 * Get titulo
	 *
	 * @return titulo
	 */

	@Schema(name = "titulo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("titulo")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Contenido productionYear(Integer productionYear) {
		this.productionYear = productionYear;
		return this;
	}

	/**
	 * Get productionYear
	 *
	 * @return productionYear
	 */

	@Schema(name = "production_year", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("production_year")
	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
	}

	public Contenido clasificacionEdad(String clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
		return this;
	}

	/**
	 * Get clasificacionEdad
	 *
	 * @return clasificacionEdad
	 */

	@Schema(name = "clasificacion_edad", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("clasificacion_edad")
	public String getClasificacionEdad() {
		return clasificacionEdad;
	}

	public void setClasificacionEdad(String clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}

	public Contenido descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	/**
	 * Get descripcion
	 *
	 * @return descripcion
	 */

	@Schema(name = "descripcion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Contenido perteneceA(Integer perteneceA) {
		this.perteneceA = perteneceA;
		return this;
	}

	/**
	 * Get perteneceA
	 *
	 * @return perteneceA
	 */

	@Schema(name = "pertenece_a", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("pertenece_a")
	public Integer getPerteneceA() {
		return perteneceA;
	}

	public void setPerteneceA(Integer perteneceA) {
		this.perteneceA = perteneceA;
	}

	public Contenido numeroElementos(Integer numeroElementos) {
		this.numeroElementos = numeroElementos;
		return this;
	}

	/**
	 * Get numeroElementos
	 *
	 * @return numeroElementos
	 */

	@Schema(name = "numero_elementos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("numero_elementos")
	public Integer getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(Integer numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public Contenido duracion(Integer duracion) {
		this.duracion = duracion;
		return this;
	}

	/**
	 * Get duracion
	 *
	 * @return duracion
	 */

	@Schema(name = "duracion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("duracion")
	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Contenido url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * Get url
	 *
	 * @return url
	 */

	@Schema(name = "url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Getter and Setter for etiquetaIds
	@Schema(name = "etiqueta_ids", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("etiqueta_ids")
	public List<Integer> getEtiquetaIds() {
		return etiquetaIds;
	}

	public void setEtiquetaIds(List<Integer> etiquetaIds) {
		this.etiquetaIds = etiquetaIds;
	}

	// Override equals, hashCode, and toString methods ...
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Contenido contenido = (Contenido) o;
		return Objects.equals(this.id, contenido.id) && Objects.equals(this.tipo, contenido.tipo) && Objects.equals(this.titulo, contenido.titulo) && Objects.equals(this.productionYear, contenido.productionYear) && Objects.equals(this.clasificacionEdad, contenido.clasificacionEdad) && Objects.equals(this.descripcion, contenido.descripcion) && Objects.equals(this.perteneceA, contenido.perteneceA) && Objects.equals(this.numeroElementos, contenido.numeroElementos) && Objects.equals(this.duracion, contenido.duracion) && Objects.equals(this.url, contenido.url) && Objects.equals(this.etiquetaIds, contenido.etiquetaIds); // Include etiquetaIds in equality check
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipo, titulo, productionYear, clasificacionEdad, descripcion, perteneceA, numeroElementos, duracion, url, etiquetaIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Contenido {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
		sb.append("    titulo: ").append(toIndentedString(titulo)).append("\n");
		sb.append("    productionYear: ").append(toIndentedString(productionYear)).append("\n");
		sb.append("    clasificacionEdad: ").append(toIndentedString(clasificacionEdad)).append("\n");
		sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
		sb.append("    perteneceA: ").append(toIndentedString(perteneceA)).append("\n");
		sb.append("    numeroElementos: ").append(toIndentedString(numeroElementos)).append("\n");
		sb.append("    duracion: ").append(toIndentedString(duracion)).append("\n");
		sb.append("    url: ").append(toIndentedString(url)).append("\n");
		sb.append("    etiquetaIds: ").append(toIndentedString(etiquetaIds)).append("\n"); // Include etiquetaIds in string representation
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

