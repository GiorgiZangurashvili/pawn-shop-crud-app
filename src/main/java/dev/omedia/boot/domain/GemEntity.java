package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "U_GEM_TYPE", columnNames = "GEM_TYPE")
})
@Getter
@Setter
public class GemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEM_ID_GEN")
    @SequenceGenerator(name = "GEM_ID_GEN", sequenceName = "GEM_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "GEM_TYPE", nullable = false, updatable = false)
    private String gemType;
}
