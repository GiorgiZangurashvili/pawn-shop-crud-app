package dev.omedia.boot.repository;

import dev.omedia.boot.domain.PawnCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PawnCarRepository extends CrudRepository<PawnCar, Long> {
}
