package dev.omedia.boot.repository;

import dev.omedia.boot.domain.Branch;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
    @Cacheable("branchCache")
    Optional<Branch> findById(long id);
}
