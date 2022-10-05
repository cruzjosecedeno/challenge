package com.labs.challenge.controllers;

import com.labs.challenge.models.Price;
import com.labs.challenge.services.PriceService;
import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/prices")
    public ResponseEntity<List<Price>> getAllPrices() {
        try {
            List<Price> prices = new ArrayList<Price>();

            priceService.getPrices().forEach(prices::add);

            return new ResponseEntity<>(prices, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lastprice")
    public ResponseEntity<Price> getLastPrice(@RequestParam(value = "brandId") int brandId, @RequestParam(value = "productId") int productId, @RequestParam(value = "datetime") String datetime) {
        try {
            LocalDateTime datetimeLocal = LocalDateTime.parse(datetime);
            Price price = priceService.getLastPrice(brandId, productId, datetimeLocal);

            return new ResponseEntity<>(price, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
