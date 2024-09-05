package ci.cantineADA.macantine.services.impl;

import ci.cantineADA.macantine.models.Plat;
import ci.cantineADA.macantine.repositories.PlatRepository;
import ci.cantineADA.macantine.services.PlatService;
import ci.cantineADA.macantine.services.dto.PlatDTO;
import ci.cantineADA.macantine.services.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PlatImpl implements PlatService {

    private final PlatRepository platRepository;

    private final PlatMapper platMapper;


    @Override
    public PlatDTO save(PlatDTO platDTO) {
        log.debug("Saving plat {}", platDTO);
        Plat plat = platMapper.toEntity(platDTO);
        plat = platRepository.save(plat);
        return platMapper.toDto(plat);
    }

    @Override
    public Optional<PlatDTO> update(PlatDTO platDTO, Long id) {
        log.debug("Request to update plat: {}", platDTO);

        return findOne(id)
                .map(existingUser -> {
                    existingUser.setName(platDTO.getName());
                    existingUser.setSummary(platDTO.getSummary());
                    return save(existingUser);
                });
    }

    @Override
    public Optional<PlatDTO> findById(Long id) {
        return platRepository.findById(id).map(platMapper::toDto);
    }

    @Override
    public Optional<PlatDTO> findOne(Long id) {
        return platRepository.findById(id).map(platMapper::toDto);
    }

    @Override
    public List<PlatDTO> findAll() {
        log.debug("List Plat {}",platRepository.findAll());
        return platRepository.findAll().stream().map(platMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Deleting plat with id {}", id);
        platRepository.deleteById(id);
    }
}
