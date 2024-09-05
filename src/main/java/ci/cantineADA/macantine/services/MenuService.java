package ci.cantineADA.macantine.services;

import ci.cantineADA.macantine.services.dto.MenuDTO;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    MenuDTO save(MenuDTO menuDTO);

    Optional<MenuDTO> update(MenuDTO menuDTO, Long id);

    Optional<MenuDTO> findById(Long id);

    Optional<MenuDTO> findOne(Long id);

    List<MenuDTO> findAll();

    void delete(Long id);

}
