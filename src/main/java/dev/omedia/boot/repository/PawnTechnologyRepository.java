package dev.omedia.boot.repository;

import dev.omedia.boot.domain.PawnTechnology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PawnTechnologyRepository extends CrudRepository<PawnTechnology, Long> {
}
