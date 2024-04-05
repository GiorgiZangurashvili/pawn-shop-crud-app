package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_PAWN_TECHNOLOGY_PAWN_ITEM"))
public class PawnTechnology extends PawnItem {
    @Column(name = "TECHNOLOGY_TYPE_ID", insertable = false, updatable = false)
    private long technologyTypeId;

    @ManyToOne
    @JoinColumn(name = "TECHNOLOGY_TYPE_ID", updatable = false, foreignKey = @ForeignKey(name = "FK_PAWN_TECHNOLOGY_TECHNOLOGY_TYPE"))
    private TechnologyEntity technologyType;

    @Column(name = "FIRM_NAME_ID", insertable = false, updatable = false)
    private long firmId;

    @ManyToOne
    @JoinColumn(name = "FIRM_NAME_ID", updatable = false, foreignKey = @ForeignKey(name = "FK_PAWN_TECHNOLOGY_FIRM_NAME"))
    private FirmEntity firmName;

    @Column(name = "DAMAGED", nullable = false)
    private boolean damaged;

    @Column(name = "DAMAGE_DESCRIPTION", columnDefinition = "TEXT", updatable = false, nullable = false)
    private String damageDescription;
}
