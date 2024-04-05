package dev.omedia.boot.repository;

import dev.omedia.boot.domain.GemEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GemEntityRepository extends CrudRepository<GemEntity, Long> {
    @Cacheable("gemCache")
    Optional<GemEntity> findById(long id);
}
