package com.requerimentsmanagement.project.business;

import com.requerimentsmanagement.project.model.Requirement;
import java.util.List;
import java.util.Optional;

/**
 * <b>Class</b>: RequirementService <br/>
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
public interface RequirementService {
    List<Requirement> listRequirement();

    Requirement addRequirement(Requirement body);

    Optional<Requirement> updateRequirement(Requirement body);

    List<Requirement> findById(Integer id);

    Boolean deleteRequirement(Integer parameter);

    String generateRequirement(Integer parameter);
}
