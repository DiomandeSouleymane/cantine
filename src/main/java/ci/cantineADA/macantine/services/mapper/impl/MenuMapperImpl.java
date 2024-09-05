package ci.cantineADA.macantine.services.mapper.impl;

import ci.cantineADA.macantine.models.Menu;
import ci.cantineADA.macantine.services.dto.MenuDTO;
import ci.cantineADA.macantine.services.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class MenuMapperImpl implements MenuMapper {

    private final ModelMapper modelMapper;

    @Override
    public MenuDTO toDto(Menu entity) {
        return modelMapper.map(entity, MenuDTO.class);
    }

    @Override
    public Menu toEntity(MenuDTO dto) {
        return modelMapper.map(dto, Menu.class);
    }
}
