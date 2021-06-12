package com.requerimentsmanagement.project.expose;

import com.requerimentsmanagement.project.business.RequirementService;
import com.requerimentsmanagement.project.model.Requirement;
import com.requerimentsmanagement.project.util.FileUploadUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * <b>Class</b>: RequirementController <br/>
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
@RestController
@RequestMapping("/requirement")
@Slf4j
@CrossOrigin
public class RequirementController {
  @Autowired
  private RequirementService requirementService;

  /**
   * This method is used to get only one responseModuleEntity.
   * @return one examples.
   * @exception IOException is a generic error.
   */
  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Listar requerimientos",
      notes = "Método para listar requerimientos",
      response = Requirement.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful Ok", response = Requirement.class),
      @ApiResponse(code = 400, message = "Request object in invalid"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 500, message = "Internal Server Error"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 415, message = "Content type not supported")})
  public List<Requirement> listRequirement() {
    return requirementService.listRequirement();
  }

  @GetMapping(value = "/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Requirement> listaRequermientById(@PathVariable("id") Integer id) {
    return requirementService.findById(id);
  }

  /**
   * This method is used to get only one responseModuleEntity.
   * @param body This is the first paramter to method.
   * @return one examples.
   * @exception IOException is a generic error.
   */
  @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Agregar requerimientos",
      notes = "Método para agregar requerimientos",
      response = Requirement.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful Ok", response = Requirement.class),
      @ApiResponse(code = 400, message = "Request object in invalid"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 500, message = "Internal Server Error"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 415, message = "Content type not supported")})
  public Requirement addRequirement(
      @ApiParam(value = "Requirement", required = true)
      @RequestBody Requirement body) throws IOException {

    return requirementService.addRequirement(body);
  }

  @PostMapping(value = "/uploadFile", produces = MediaType.APPLICATION_JSON_VALUE)
  public Boolean uploadFile(
          @RequestParam("excel") MultipartFile multipartFile) throws IOException {

    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());


    String uploadDir = "file-excel/";

    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

    return true;
  }

  /**
   * This method is used to get only one responseModuleEntity.
   * @param body This is the first paramter to method.
   * @return one examples.
   * @exception IOException is a generic error.
   */
  @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Actualizar requerimientos",
      notes = "Método para actualizar requerimientos",
      response = Optional.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful Ok", response = Optional.class),
      @ApiResponse(code = 400, message = "Request object in invalid"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 500, message = "Internal Server Error"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 415, message = "Content type not supported")})
  public Optional<Requirement> updateRequirement(
      @ApiParam(value = "Requirement", required = true)
      @RequestBody Requirement body) {
    log.info(body.toString());
    return requirementService.updateRequirement(body);
  }

  /**
   * This method is used to get only one responseModuleEntity.
   * @param parameter This is the first paramter to method.
   * @return one examples.
   * @exception IOException is a generic error.
   */
  @DeleteMapping(value = "/delete/{idRequirement}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Eliminar requerimientos",
      notes = "Método para eliminar requerimientos",
      response = Boolean.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful Ok", response = Boolean.class),
      @ApiResponse(code = 400, message = "Request object in invalid"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 500, message = "Internal Server Error"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 415, message = "Content type not supported")})
  public Boolean deleteRequirement(
      @ApiParam(value = "idRequirement", required = true)
      @PathVariable("idRequirement") Integer parameter) {
    log.info(parameter.toString());
    return requirementService.deleteRequirement(parameter);
  }

  /**
   * This method is used to get only one responseModuleEntity.
   * @param parameter This is the first paramter to method.
   * @return one examples.
   * @exception IOException is a generic error.
   */
  @GetMapping(value = "/generate-requirement/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Generar requerimientos",
      notes = "Método para generar requerimientos",
      response = String.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful Ok", response = String.class),
      @ApiResponse(code = 400, message = "Request object in invalid"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 500, message = "Internal Server Error"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 415, message = "Content type not supported")})
  public String generateRequirement(
          @ApiParam(value = "amount", required = true)
          @PathVariable("amount") Integer parameter) {
    log.info(String.valueOf(parameter));
    return requirementService.generateRequirement(parameter);
  }
}
