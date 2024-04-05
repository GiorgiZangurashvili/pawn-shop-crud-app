package dev.omedia.boot.scheduler;

import dev.omedia.boot.domain.PawnItem;
import dev.omedia.boot.repository.PawnItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

@RequiredArgsConstructor
public class ScheduledMethods {
    private final CacheManager cacheManager;
    private final PawnItemRepository repository;

    @Scheduled(cron = "0 0 * * *")
    public void checkIfPayedFullFeeScheduled() {
        LocalDate currentDate = LocalDate.now();
        checkIfPayedFullFee(currentDate, repository);
    }

    public void checkIfPayedFullFee(LocalDate currentDate, PawnItemRepository pawnItemRepository) {
        ArrayList<PawnItem> items = pawnItemRepository.findAllByPawnDateDayOfMonth(currentDate.minusDays(1).getDayOfMonth());
        items
                .forEach(item -> {
                    LocalDate pawnDate = item.getPawnDate();
                    long monthsBetween = ChronoUnit.MONTHS.between(pawnDate, currentDate.minusDays(1));
                    int paidAmount = item.getPaidAmount();
                    long monthlyAverage = paidAmount / monthsBetween;
                    if (monthlyAverage < item.getMonthlyFee()) {
                        item.setConfiscated(true);
                        pawnItemRepository.save(item);
                    }
                });
    }

    @Scheduled(cron = "0 */8 * * *")
    public void updateCache() {
        Objects.requireNonNull(cacheManager.getCache("brandCache")).clear();
        Objects.requireNonNull(cacheManager.getCache("firmCache")).clear();
        Objects.requireNonNull(cacheManager.getCache("gemCache")).clear();
        Objects.requireNonNull(cacheManager.getCache("technologyCache")).clear();
        Objects.requireNonNull(cacheManager.getCache("branchCache")).clear();
    }
}
