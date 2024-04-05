package dev.omedia.boot.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.omedia.boot.domain.FirmEntity;
import dev.omedia.boot.domain.TechnologyEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Schema(title = "PawnTechnology", description = "Stores PawnTechnology data in database")
//@JsonTypeName("technology")
public class PawnTechnologyDTO extends PawnItemDTO {
    @Schema(description = "Technology type id")
    private long technologyTypeId;
    @Schema(description = "Technology type")
    private TechnologyEntity technologyType;
    @Schema(description = "Firm id")
    private long firmId;
    @Schema(description = "Firm's name")
    private FirmEntity firmName;
    @Schema(description = "Represents if item is damaged")
    private boolean damaged;
    @Schema(description = "Item's damage description")
    private String damageDescription;
}
