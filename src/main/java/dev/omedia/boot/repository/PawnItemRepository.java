package dev.omedia.boot.repository;

import dev.omedia.boot.domain.PawnItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PawnItemRepository extends CrudRepository<PawnItem, Long> {
    ArrayList<PawnItem> findAll();

    @Query("SELECT e FROM PawnItem e WHERE DAY(e.pawnDate) = ?1")
    ArrayList<PawnItem> findAllByPawnDateDayOfMonth(int dayOfMonth);
}
