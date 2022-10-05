package com.labs.challenge.initializer;

import com.labs.challenge.models.Price;
import com.labs.challenge.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        priceRepository.save(new Price(1L, 1, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),1, 35455L, (short) 0, 35.50, "EUR" ));
        priceRepository.save(new Price(2L, 1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"),2, 35455L, (short) 1, 25.45, "EUR" ));
        priceRepository.save(new Price(3L, 1, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"),3, 35455L, (short) 1, 30.50, "EUR" ));
        priceRepository.save(new Price(4L, 1, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),4, 35455L, (short) 1, 38.95, "EUR" ));
        priceRepository.save(new Price(5L, 2, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),4, 35455L, (short) 1, 22.95, "EUR" ));
        priceRepository.save(new Price(6L, 2, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),4, 35455L, (short) 1, 26.95, "EUR" ));
    }
}
