package com.requerimentsmanagement.project.mapper;

import com.requerimentsmanagement.project.model.Requirement;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

/**
 * <b>Class</b>: RequirementMapper <br/>
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
@ApiModel(description = "RequirementMapper")
@Mapper
public interface RequirementMapper {

    @Select("Select * from requerimiento")
    public List<Requirement> listRequirement();

    @Update("UPDATE requerimiento SET " +
            "nombres=#{rq.nombres}, " +
            "apellidos=#{rq.apellidos}, " +
            "area=#{rq.area}, " +
            "solicitud=#{rq.solicitud}, " +
            "descripcion=#{rq.descripcion}, " +
            "anexo=#{rq.anexo}, " +
            "analistaAsignado=#{rq.analistaAsignado}, " +
            "estado=#{rq.estado}, " +
            "fechaRegistro=#{rq.fechaRegistro} " +
            " WHERE idRequerimiento=#{rq.idRequerimiento}")
    public Integer updateRequirement(@Param("rq") Requirement rq);

    @Delete("DELETE FROM requerimiento WHERE idRequerimiento =#{id} ")
    public Integer deleteRequirement(@Param("id") Integer id);

    @Select("Select * from requerimiento where idRequerimiento =#{id} ")
    public List<Requirement> listById(@Param("id")Integer id);

    @Insert("INSERT INTO requerimiento(nombres,apellidos,area,solicitud,descripcion,anexo,analistaAsignado,estado,fechaRegistro) " +
            "VALUES " +
            "(#{rq.nombres},#{rq.apellidos},#{rq.area},#{rq.solicitud},#{rq.descripcion},#{rq.anexo},#{rq.analistaAsignado},#{rq.estado},#{rq.fechaRegistro})")
    public Integer addRequirement(@Param("rq") Requirement rq);
}
