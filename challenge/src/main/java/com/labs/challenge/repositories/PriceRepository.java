package com.labs.challenge.repositories;

import java.time.LocalDateTime;
import java.util.List;
import com.labs.challenge.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc (int brandId, long productId, LocalDateTime startDate, LocalDateTime endDate);
}