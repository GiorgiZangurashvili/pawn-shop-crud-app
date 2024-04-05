package dev.omedia.boot.mapper;

import dev.omedia.boot.domain.PawnTechnology;
import dev.omedia.boot.dto.PawnTechnologyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PawnTechnologyMapper {
    PawnTechnology map(PawnTechnologyDTO dto);
    PawnTechnologyDTO map(PawnTechnology entity);
    List<PawnTechnology> mapDTOsToEntities(List<PawnTechnologyDTO> dtos);
    List<PawnTechnologyDTO> mapEntitiesToDTOs(List<PawnTechnology> entities);
}
