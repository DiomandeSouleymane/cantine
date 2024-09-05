package ci.cantineADA.macantine.services;

import ci.cantineADA.macantine.services.dto.MenuDTO;
import ci.cantineADA.macantine.services.dto.PlatDTO;

import java.util.List;
import java.util.Optional;

public interface PlatService {

    PlatDTO save(PlatDTO platDTO);

    Optional<PlatDTO> update(PlatDTO platDTO, Long id);

    Optional<PlatDTO> findById(Long id);

    Optional<PlatDTO> findOne(Long id);

    List<PlatDTO> findAll();

    void delete(Long id);
}
