package dev.omedia.boot.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.omedia.boot.domain.GemEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Schema(title = "PawnJewelery", description = "Stores PawnJewelery data in database")
//@JsonTypeName("jewelery")
public class PawnJeweleryDTO extends PawnItemDTO{
    @Schema(description = "PawnJewelery description")
    private String description;
    @Schema(description = "Used gem ids in jewelery")
    private Set<Long> usedGemEntityIds;
    @Schema(description = "Used gems in jewelery")
    private Set<GemEntity> usedGemEntities;
}
