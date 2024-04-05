package dev.omedia.boot.mapper;

import dev.omedia.boot.domain.PawnCar;
import dev.omedia.boot.dto.PawnCarDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PawnCarMapper {
    PawnCar map(PawnCarDTO dto);
    PawnCarDTO map(PawnCar entity);
    List<PawnCar> mapDTOsToEntities(List<PawnCarDTO> dtos);
    List<PawnCarDTO> mapEntitiesToDTOs(List<PawnCar> entities);
}
