package com.labs.challenge.services;

import com.labs.challenge.models.Price;
import com.labs.challenge.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class PriceService {
    @Autowired
    PriceRepository priceRepository;

    public ArrayList<Price> getPrices(){
        return (ArrayList<Price>)priceRepository.findAll();
    }

    public Price getLastPrice(int brandId, long productId, LocalDateTime datetime){
        ArrayList<Price> prices = (ArrayList<Price>)priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, datetime, datetime);

        if(prices.isEmpty()) return null;

        return prices.get(0);
    }
}

