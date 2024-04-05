package dev.omedia.boot.mapper;

import dev.omedia.boot.domain.PawnItem;
import dev.omedia.boot.dto.PawnItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PawnItemMapper {
    PawnItem map(PawnItemDTO dto);
    PawnItemDTO map(PawnItem entity);
    List<PawnItem> mapDTOsToEntities(List<PawnItemDTO> dtos);
    List<PawnItemDTO> mapEntitiesToDTOs(List<PawnItem> entities);
}
