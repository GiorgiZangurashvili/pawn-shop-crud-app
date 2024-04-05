package dev.omedia.boot.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "U_PERSON_PERSONAL_NO", columnNames = "PERSON_PERSONAL_NO")
})
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PawnItem.class, name = "item"),
        @JsonSubTypes.Type(value = PawnCar.class, name = "car"),
        @JsonSubTypes.Type(value = PawnJewelery.class, name = "jewelery"),
        @JsonSubTypes.Type(value = PawnTechnology.class, name = "technology")
})
@ToString
public class PawnItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_ID_GEN")
    @SequenceGenerator(name = "ITEM_ID_GEN", sequenceName = "ITEM_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "PERSON_PERSONAL_NO", updatable = false, length = 9, nullable = false)
    private String personPersonalNo;

    @Column(name = "PAWN_DATE", updatable = false, nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pawnDate;

    @Column(name = "BRANCH_ID", insertable = false, updatable = false, nullable = false)
    private long branchId;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_PAWN_ITEM_BRANCH_ID"))
    private Branch branch;

    @Column(name = "PAID_AMOUNT", nullable = false)
    private int paidAmount;

    @Column(name = "MONTHLY_FEE", updatable = false, nullable = false)
    private int monthlyFee;

    @Column(name = "FULL_FEE", updatable = false, nullable = false)
    private int fullFee;

    @Column(name = "TAKEN_OUT", nullable = false)
    private boolean takenOut;

    @Column(name = "CONFISCATED", nullable = false)
    private boolean confiscated;
}
