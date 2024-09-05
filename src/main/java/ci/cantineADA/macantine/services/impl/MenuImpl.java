package ci.cantineADA.macantine.services.impl;



import ci.cantineADA.macantine.models.Menu;
import ci.cantineADA.macantine.models.Plat;
import ci.cantineADA.macantine.repositories.MenuRepository;
import ci.cantineADA.macantine.repositories.PlatRepository;
import ci.cantineADA.macantine.services.MenuService;
import ci.cantineADA.macantine.services.dto.MenuDTO;
import ci.cantineADA.macantine.services.mapper.MenuMapper;
import ci.cantineADA.macantine.services.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MenuImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    @Override
    public MenuDTO save(MenuDTO menuDTO) {

        log.debug("Saving menu {}", menuDTO);
        Menu menu = menuMapper.toEntity(menuDTO);
        menu = menuRepository.save(menu);
        return menuMapper.toDto(menu);
    }

    @Override
    public Optional<MenuDTO> update(MenuDTO menuDTO, Long id) {
        log.debug("Request to update menu: {}", menuDTO);

        return findOne(id)
                .map(existingUser -> {
                    existingUser.setCreationDate(menuDTO.getCreationDate());
                    existingUser.setPlat(menuDTO.getPlat());
                    return save(existingUser);
                });
    }

    @Override
    public Optional<MenuDTO> findById(Long id) {
        return menuRepository.findById(id).map(menuMapper::toDto);
    }

    @Override
    public Optional<MenuDTO> findOne(Long id) {
        return menuRepository.findById(id).map(menuMapper::toDto);
    }

    @Override
    public List<MenuDTO> findAll() {
        log.debug("List Menu {}",menuRepository.findAll());
        return menuRepository.findAll().stream().map(menuMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Deleting plat with id {}", id);
        menuRepository.deleteById(id);
    }
}
