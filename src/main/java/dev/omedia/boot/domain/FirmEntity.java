package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "U_FIRM_NAME", columnNames = "FIRM_NAME")
})
@Getter
@Setter
public class FirmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIRM_ID_GEN")
    @SequenceGenerator(name = "FIRM_ID_GEN", sequenceName = "FIRM_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "FIRM_NAME", nullable = false, updatable = false)
    private String firmName;
}
