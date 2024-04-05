package dev.omedia.boot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_ID_GEN")
    @SequenceGenerator(name = "BRANCH_ID_GEN", sequenceName = "BRANCH_ID_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "NAME", nullable = false, updatable = false)
    private String name;
}
