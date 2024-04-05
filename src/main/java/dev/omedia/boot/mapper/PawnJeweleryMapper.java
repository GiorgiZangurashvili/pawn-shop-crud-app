package dev.omedia.boot.mapper;

import dev.omedia.boot.domain.PawnJewelery;
import dev.omedia.boot.dto.PawnJeweleryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PawnJeweleryMapper {
    PawnJewelery map(PawnJeweleryDTO dto);
    PawnJeweleryDTO map(PawnJewelery entity);
    List<PawnJewelery> mapDTOsToEntities(List<PawnJeweleryDTO> dtos);
    List<PawnJeweleryDTO> mapEntitiesToDTOs(List<PawnJewelery> entities);
}
