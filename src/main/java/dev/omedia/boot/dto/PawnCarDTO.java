package dev.omedia.boot.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.omedia.boot.domain.BrandEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@NoArgsConstructor
@Getter
@Setter
@Schema(title = "PawnCar", description = "Stores PawnCar data in database")
//@JsonTypeName("car")
public class PawnCarDTO extends PawnItemDTO {
    @Schema(description = "Car's brandId")
    private long brandId;
    @Schema(description = "Car's brand")
    private BrandEntity brand;
    @Schema(description = "Car's model release date")
    @Positive(message = "Model release date should be positive number")
    private int releaseDate;
    @Schema(description = "Car's odometer value")
    @PositiveOrZero(message = "Odometer value should be positive or zero")
    private int odometerValue;
}
