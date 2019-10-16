package cl.ingerencia.api.algolia.swagger.codegen.model;

import java.util.Objects;
import cl.ingerencia.api.algolia.swagger.codegen.model.Articulo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Paginacion
 */
@Validated

public class Paginacion   {
  @JsonProperty("articulos")
  @Valid
  private List<Articulo> articulos = null;

  @JsonProperty("hitsPerPage")
  private Integer hitsPerPage = null;

  @JsonProperty("nbHits")
  private Integer nbHits = null;

  @JsonProperty("nbPages")
  private Integer nbPages = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("params")
  private String params = null;

  @JsonProperty("processingTimeMS")
  private Integer processingTimeMS = null;

  @JsonProperty("query")
  private String query = null;

  public Paginacion articulos(List<Articulo> articulos) {
    this.articulos = articulos;
    return this;
  }

  public Paginacion addArticulosItem(Articulo articulosItem) {
    if (this.articulos == null) {
      this.articulos = new ArrayList<>();
    }
    this.articulos.add(articulosItem);
    return this;
  }

  /**
   * Get articulos
   * @return articulos
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Articulo> getArticulos() {
    return articulos;
  }

  public void setArticulos(List<Articulo> articulos) {
    this.articulos = articulos;
  }

  public Paginacion hitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
    return this;
  }

  /**
   * Get hitsPerPage
   * @return hitsPerPage
  **/
  @ApiModelProperty(value = "")


  public Integer getHitsPerPage() {
    return hitsPerPage;
  }

  public void setHitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
  }

  public Paginacion nbHits(Integer nbHits) {
    this.nbHits = nbHits;
    return this;
  }

  /**
   * Get nbHits
   * @return nbHits
  **/
  @ApiModelProperty(value = "")


  public Integer getNbHits() {
    return nbHits;
  }

  public void setNbHits(Integer nbHits) {
    this.nbHits = nbHits;
  }

  public Paginacion nbPages(Integer nbPages) {
    this.nbPages = nbPages;
    return this;
  }

  /**
   * Get nbPages
   * @return nbPages
  **/
  @ApiModelProperty(value = "")


  public Integer getNbPages() {
    return nbPages;
  }

  public void setNbPages(Integer nbPages) {
    this.nbPages = nbPages;
  }

  public Paginacion page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  **/
  @ApiModelProperty(value = "")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Paginacion params(String params) {
    this.params = params;
    return this;
  }

  /**
   * Get params
   * @return params
  **/
  @ApiModelProperty(value = "")


  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public Paginacion processingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
    return this;
  }

  /**
   * Get processingTimeMS
   * @return processingTimeMS
  **/
  @ApiModelProperty(value = "")


  public Integer getProcessingTimeMS() {
    return processingTimeMS;
  }

  public void setProcessingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
  }

  public Paginacion query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  **/
  @ApiModelProperty(value = "")


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paginacion paginacion = (Paginacion) o;
    return Objects.equals(this.articulos, paginacion.articulos) &&
        Objects.equals(this.hitsPerPage, paginacion.hitsPerPage) &&
        Objects.equals(this.nbHits, paginacion.nbHits) &&
        Objects.equals(this.nbPages, paginacion.nbPages) &&
        Objects.equals(this.page, paginacion.page) &&
        Objects.equals(this.params, paginacion.params) &&
        Objects.equals(this.processingTimeMS, paginacion.processingTimeMS) &&
        Objects.equals(this.query, paginacion.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(articulos, hitsPerPage, nbHits, nbPages, page, params, processingTimeMS, query);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Paginacion {\n");
    
    sb.append("    articulos: ").append(toIndentedString(articulos)).append("\n");
    sb.append("    hitsPerPage: ").append(toIndentedString(hitsPerPage)).append("\n");
    sb.append("    nbHits: ").append(toIndentedString(nbHits)).append("\n");
    sb.append("    nbPages: ").append(toIndentedString(nbPages)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    processingTimeMS: ").append(toIndentedString(processingTimeMS)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

