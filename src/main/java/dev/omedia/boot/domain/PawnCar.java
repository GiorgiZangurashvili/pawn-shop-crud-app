package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_PAWN_CAR_PAWN_ITEM"))
public class PawnCar extends PawnItem {
    @Column(name = "BRAND_ID", insertable = false, updatable = false)
    private long brandId;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", updatable = false, foreignKey = @ForeignKey(name = "FK_PAWN_CAR_BRAND_ID"))
    private BrandEntity brand;

    @Column(name = "RELEASE_DATE", updatable = false)
    private int releaseDate;

    @Column(name = "ODOMETER_VALUE")
    private int odometerValue;
}
