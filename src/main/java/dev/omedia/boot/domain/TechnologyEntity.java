package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "U_TECHNOLOGY_TYPE", columnNames = "TECHNOLOGY_TYPE")
})
@Getter
@Setter
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TECHNOLOGY_ID_GEN")
    @SequenceGenerator(name = "TECHNOLOGY_ID_GEN", sequenceName = "TECHNOLOGY_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "TECHNOLOGY_TYPE", nullable = false,
            updatable = false)
    private String technologyType;
}
