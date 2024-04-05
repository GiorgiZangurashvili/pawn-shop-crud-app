package dev.omedia.boot.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.omedia.boot.domain.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Schema(title = "PawnItem", description = "Stores PawnItem data in database")
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PawnCarDTO.class, name = "PawnCarDTO"),
        @JsonSubTypes.Type(value = PawnJeweleryDTO.class, name = "PawnJeweleryDTO"),
        @JsonSubTypes.Type(value = PawnTechnologyDTO.class, name = "PawnTechnologyDTO")
})
public class PawnItemDTO {
    @Schema(description = "PawnItem's id")
    private long id;
    @Schema(description = "Person's personal number")
    @Pattern(regexp = "\\d+", message = "Only digits are allowed")
    @Size(min = 9, max = 9, message = "Personal number must be exactly 9 characters")
    private String personPersonalNo;
    @Schema(description = "Pawn date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pawnDate;
    @Schema(description = "Branch id")
    private long branchId;
    @Schema(description = "Branch")
    private Branch branch;
    @Schema(description = "Person's paid amount of money")
    private int paidAmount;
    @Schema(description = "Monthly fee that person should pay")
    @Positive(message = "Monthly fee should be positive")
    private int monthlyFee;
    @Schema(description = "Full fee")
    @Positive(message = "Full fee must be positive")
    private int fullFee;
    @Schema(description = "Represents if item is taken out of pawn")
    private boolean takenOut;
    @Schema(description = "Represents if item is confiscated or not")
    private boolean confiscated;
}
