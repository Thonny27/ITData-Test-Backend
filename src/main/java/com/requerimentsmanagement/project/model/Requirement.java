package com.requerimentsmanagement.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * <b>Class</b>: Requirement <br/>
 * <b>Copyright</b>: 2021 AL - Anthony Luyo <br/>.
 *
 * @author 2021 AL - Anthony Luyo <br/>
 * <u>Service Provider</u>: AL <br/>
 * <u>Developed by</u>: Anthony Luyo <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     June 11, 2021 Creación de Clase.
 *   </li>
 * </ul>
 */
@ApiModel(description = "Requirement")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Requirement {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idRequerimiento")
  @ApiModelProperty(value = "idRequerimiento", example = "122")
  private Integer idRequerimiento;

  @JsonProperty("nombres")
  @ApiModelProperty(value = "nombres", example = "Pedro Fernando")
  private String nombres;

  @JsonProperty("apellidos")
  @ApiModelProperty(value = "apellidos", example = "Suarez Mesa")
  private String apellidos;

  @JsonProperty("area")
  @ApiModelProperty(value = "area", example = "Sistemas")
  private String area;

  @JsonProperty("solicitud")
  @ApiModelProperty(value = "solicitud", example = "solicito desarrollo de mensajeria automatizada")
  private String solicitud;

  @JsonProperty("descripcion")
  @ApiModelProperty(value = "descripcion", example = "Descripcion")
  private String descripcion;

  @JsonProperty("anexo")
  @ApiModelProperty(value = "anexo", example = "987654321")
  private String anexo;

  @JsonProperty("analistaAsignado")
  @ApiModelProperty(value = "analistaAsignado", example = "Mario Castañeda")
  private String analistaAsignado;

  @JsonProperty("estado")
  @ApiModelProperty(value = "estado", example = "1")
  private Integer estado;

  @JsonProperty("fechaRegistro")
  @ApiModelProperty(value = "fechaRegistro", example = "Ciudad")
  private LocalDate fechaRegistro;
}
