package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_PAWN_JEWELERY_PAWN_ITEM"))
public class PawnJewelery extends PawnItem {
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "USED_GEM_TYPES",
            joinColumns = @JoinColumn(name = "JEWELERY_ITEM_ID", foreignKey = @ForeignKey(name = "FK_USED_GEM_TYPES_JEWELERY_ITEM_ID")),
            inverseJoinColumns = @JoinColumn(name = "GEM_TYPE_ID", foreignKey = @ForeignKey(name = "FK_USED_GEM_TYPES_GEM_TYPE_ID"))
    )
    private Set<GemEntity> usedGemEntities;
}
