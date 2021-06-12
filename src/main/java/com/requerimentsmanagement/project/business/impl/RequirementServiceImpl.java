package com.requerimentsmanagement.project.business.impl;

import com.requerimentsmanagement.project.business.RequirementService;
import com.requerimentsmanagement.project.mapper.RequirementMapper;
import com.requerimentsmanagement.project.model.Requirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * <b>Class</b>: RequirementServiceImpl <br/>
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
@Service
@Slf4j
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    RequirementMapper requirementMapper;

    @Override
    public List<Requirement> listRequirement() {
        log.info("Listado:");
        return requirementMapper.listRequirement();
    }

    @Override
    public Requirement addRequirement(Requirement body) {
        log.info("Agregar: " + body);
        try {
            requirementMapper.addRequirement(body);
        } catch(Exception e) {
            log.error(String.valueOf(e));
        }
        return body;
    }

    @Override
    public Optional<Requirement> updateRequirement(Requirement body) {
        log.info("Actualizar: " + body);
        requirementMapper.updateRequirement(body);
        return Optional.of(body);
    }

    @Override
    public List<Requirement> findById(Integer id) {
        return requirementMapper.listById(id);
    }

    @Override
    public Boolean deleteRequirement(Integer parameter) {
        log.info("Eliminar: " + parameter);
        try {
            requirementMapper.deleteRequirement(parameter);
        } catch(Exception e) {
            log.error(String.valueOf(e));
        }
        return true;
    }

    @Override
    public String generateRequirement(Integer parameter) {
        LocalDate localDate = LocalDate.now();
        for (int i = 0 ; i < parameter ; i++) {
            addRequirement(Requirement
                .builder()
                .nombres("Nombres" + i)
                .apellidos("Apellidos " + i)
                .area("Area " + i)
                .solicitud("Solicitud" + i)
                .descripcion("Descripcion" + i)
                .anexo("9" + generateRandomNumber(11111111, 99999999))
                .analistaAsignado("Analista" + i)
                .estado(Integer.parseInt(generateRandomNumber(0, 3)))
                .fechaRegistro(localDate)
                .build());
        }
        return "Base de datos poblada con " + parameter + " registros.";
    }

    private String generateRandomNumber(Integer from, Integer to) {
        return new Random().nextInt(to - from + 1) + from + "";
    }
}
