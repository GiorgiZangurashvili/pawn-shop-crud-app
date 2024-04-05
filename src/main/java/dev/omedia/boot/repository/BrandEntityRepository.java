package dev.omedia.boot.repository;

import dev.omedia.boot.domain.BrandEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BrandEntityRepository extends CrudRepository<BrandEntity, Long> {
    @Cacheable("brandCache")
    Optional<BrandEntity> findById(long id);
}
