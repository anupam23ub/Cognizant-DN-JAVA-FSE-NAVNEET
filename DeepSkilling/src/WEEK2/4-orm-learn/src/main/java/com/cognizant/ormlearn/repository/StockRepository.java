package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * StockRepository (Doc 2 / Hands-on 2) - Query Methods only, no @Query.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // All FB stocks within a date range (used for September 2019)
    List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);

    // All GOOGL stocks with close price greater than a threshold (1250)
    List<Stock> findByCodeAndCloseGreaterThan(String code, double close);

    // Top 3 dates with the highest transaction volume (across all stocks)
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Three dates when a stock's close was the lowest (used for NFLX)
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
