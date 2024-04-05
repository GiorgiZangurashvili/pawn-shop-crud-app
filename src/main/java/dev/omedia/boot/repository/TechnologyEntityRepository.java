package dev.omedia.boot.repository;

import dev.omedia.boot.domain.TechnologyEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TechnologyEntityRepository extends CrudRepository<TechnologyEntity, Long> {
    @Cacheable("technologyCache")
    Optional<TechnologyEntity> findById(long id);
}
