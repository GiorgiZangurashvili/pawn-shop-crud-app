package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "U_BRAND_NAME", columnNames = "NAME")
})
@Getter
@Setter
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_ID_GEN")
    @SequenceGenerator(name = "BRAND_ID_GEN", sequenceName = "BRAND_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "NAME", nullable = false, updatable = false)
    private String name;
}
