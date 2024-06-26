package dev.omedia.boot.repository;

import dev.omedia.boot.domain.PawnJewelery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PawnJeweleryRepository extends CrudRepository<PawnJewelery, Long> {
}
