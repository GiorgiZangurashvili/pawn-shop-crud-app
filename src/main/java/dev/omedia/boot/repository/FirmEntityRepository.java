package dev.omedia.boot.repository;

import dev.omedia.boot.domain.FirmEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FirmEntityRepository extends CrudRepository<FirmEntity, Long> {
    @Cacheable("firmCache")
    Optional<FirmEntity> findById(long id);
}
