package ci.cantineADA.macantine.services.mapper.impl;

import ci.cantineADA.macantine.models.Plat;
import ci.cantineADA.macantine.services.dto.PlatDTO;
import ci.cantineADA.macantine.services.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlatMapperImpl implements PlatMapper {

    private final ModelMapper modelMapper;

    @Override
    public PlatDTO toDto(Plat entity) {
        return modelMapper.map(entity, PlatDTO.class);
    }

    @Override
    public Plat toEntity(PlatDTO dto) {
        return modelMapper.map(dto, Plat.class);
    }
}
