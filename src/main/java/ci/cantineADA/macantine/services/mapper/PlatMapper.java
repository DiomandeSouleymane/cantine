package ci.cantineADA.macantine.services.mapper;

import ci.cantineADA.macantine.models.Plat;
import ci.cantineADA.macantine.services.dto.PlatDTO;

public interface PlatMapper extends EntityMapper<PlatDTO, Plat> {

    PlatDTO toDto(Plat entity);

    Plat toEntity(PlatDTO dto);
}
