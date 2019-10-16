package cl.ingerencia.api.algolia.swagger.codegen.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Articulo
 */
@Validated

public class Articulo   {
  @JsonProperty("created_at")
  private OffsetDateTime createdAt = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("author")
  private String author = null;

  @JsonProperty("points")
  private BigDecimal points = null;

  @JsonProperty("objectID")
  private BigDecimal objectID = null;

  @JsonProperty("comment_text")
  private String commentText = null;

  public Articulo createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Articulo title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Articulo url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Articulo author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
  **/
  @ApiModelProperty(value = "")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Articulo points(BigDecimal points) {
    this.points = points;
    return this;
  }

  /**
   * Get points
   * @return points
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPoints() {
    return points;
  }

  public void setPoints(BigDecimal points) {
    this.points = points;
  }

  public Articulo objectID(BigDecimal objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Get objectID
   * @return objectID
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getObjectID() {
    return objectID;
  }

  public void setObjectID(BigDecimal objectID) {
    this.objectID = objectID;
  }

  public Articulo commentText(String commentText) {
    this.commentText = commentText;
    return this;
  }

  /**
   * Get commentText
   * @return commentText
  **/
  @ApiModelProperty(value = "")


  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Articulo articulo = (Articulo) o;
    return Objects.equals(this.createdAt, articulo.createdAt) &&
        Objects.equals(this.title, articulo.title) &&
        Objects.equals(this.url, articulo.url) &&
        Objects.equals(this.author, articulo.author) &&
        Objects.equals(this.points, articulo.points) &&
        Objects.equals(this.objectID, articulo.objectID) &&
        Objects.equals(this.commentText, articulo.commentText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, title, url, author, points, objectID, commentText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Articulo {\n");
    
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    commentText: ").append(toIndentedString(commentText)).append("\n");
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

