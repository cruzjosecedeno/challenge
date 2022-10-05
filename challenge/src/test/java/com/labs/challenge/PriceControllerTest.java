package com.labs.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.challenge.controllers.PriceController;
import com.labs.challenge.models.Price;
import com.labs.challenge.services.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {
    @MockBean
    private PriceService priceService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnLastPriceCase1() throws Exception {

        // PREPARE DATA INITIAL
        int brandIdSearch = 1;
        long productIdSearch = 35455;
        String datetimeSearch = "2020-06-14T10:00:00";

        // DATA VALIDATION
        Price price = new Price(1L, 1, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),1, 35455L, (short) 0, 35.50, "EUR" );

        // EXECUTE VALIDATIONS
        when(priceService.getLastPrice(brandIdSearch,productIdSearch, LocalDateTime.parse(datetimeSearch))).thenReturn(price);

        mockMvc.perform(get("/api/lastprice?brandId={brandIdSearch}&productId={productIdSearch}&datetime={datetimeSearch}", brandIdSearch, productIdSearch, datetimeSearch)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(price.getId()))
                .andExpect(jsonPath("$.brandId").value(price.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(price.getPriceList()))
                .andExpect(jsonPath("$.productId").value(price.getProductId()))
                .andExpect(jsonPath("$.price").value(price.getPrice()))
                .andExpect(jsonPath("$.currency").value(price.getCurrency()))
                .andDo(print());
    }

    @Test
    void shouldReturnLastPriceCase2() throws Exception {

        // PREPARE DATA INITIAL
        int brandIdSearch = 1;
        long productIdSearch = 35455;
        String datetimeSearch = "2020-06-14T16:00:00";

        // DATA VALIDATION
        Price price = new Price(2L, 1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"),2, 35455L, (short) 1, 25.45, "EUR" );

        // EXECUTE VALIDATIONS
        when(priceService.getLastPrice(brandIdSearch,productIdSearch, LocalDateTime.parse(datetimeSearch))).thenReturn(price);

        mockMvc.perform(get("/api/lastprice?brandId={brandIdSearch}&productId={productIdSearch}&datetime={datetimeSearch}", brandIdSearch, productIdSearch, datetimeSearch)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(price.getId()))
                .andExpect(jsonPath("$.brandId").value(price.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(price.getPriceList()))
                .andExpect(jsonPath("$.productId").value(price.getProductId()))
                .andExpect(jsonPath("$.price").value(price.getPrice()))
                .andExpect(jsonPath("$.currency").value(price.getCurrency()))
                .andDo(print());
    }

    @Test
    void shouldReturnLastPriceCase3() throws Exception {

        // PREPARE DATA INITIAL
        int brandIdSearch = 1;
        long productIdSearch = 35455;
        String datetimeSearch = "2020-06-14T21:00:00";

        // DATA VALIDATION
        Price price = new Price(2L, 1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"),2, 35455L, (short) 1, 25.45, "EUR" );

        // EXECUTE VALIDATIONS
        when(priceService.getLastPrice(brandIdSearch,productIdSearch, LocalDateTime.parse(datetimeSearch))).thenReturn(price);

        mockMvc.perform(get("/api/lastprice?brandId={brandIdSearch}&productId={productIdSearch}&datetime={datetimeSearch}", brandIdSearch, productIdSearch, datetimeSearch)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(price.getId()))
                .andExpect(jsonPath("$.brandId").value(price.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(price.getPriceList()))
                .andExpect(jsonPath("$.productId").value(price.getProductId()))
                .andExpect(jsonPath("$.price").value(price.getPrice()))
                .andExpect(jsonPath("$.currency").value(price.getCurrency()))
                .andDo(print());
    }

    @Test
    void shouldReturnLastPriceCase4() throws Exception {

        // PREPARE DATA INITIAL
        int brandIdSearch = 1;
        long productIdSearch = 35455;
        String datetimeSearch = "2020-06-15T10:00:00";

        // DATA VALIDATION
        Price price = new Price(3L, 1, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"),3, 35455L, (short) 1, 30.50, "EUR");

        // EXECUTE VALIDATIONS
        when(priceService.getLastPrice(brandIdSearch,productIdSearch, LocalDateTime.parse(datetimeSearch))).thenReturn(price);

        mockMvc.perform(get("/api/lastprice?brandId={brandIdSearch}&productId={productIdSearch}&datetime={datetimeSearch}", brandIdSearch, productIdSearch, datetimeSearch)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(price.getId()))
                .andExpect(jsonPath("$.brandId").value(price.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(price.getPriceList()))
                .andExpect(jsonPath("$.productId").value(price.getProductId()))
                .andExpect(jsonPath("$.price").value(price.getPrice()))
                .andExpect(jsonPath("$.currency").value(price.getCurrency()))
                .andDo(print());
    }

    @Test
    void shouldReturnLastPriceCase5() throws Exception {

        // PREPARE DATA INITIAL
        int brandIdSearch = 1;
        long productIdSearch = 35455;
        String datetimeSearch = "2020-06-16T21:00:00";

        // DATA VALIDATION
        Price price = new Price(4L, 1, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),4, 35455L, (short) 1, 38.95, "EUR");

        // EXECUTE VALIDATIONS
        when(priceService.getLastPrice(brandIdSearch,productIdSearch, LocalDateTime.parse(datetimeSearch))).thenReturn(price);

        mockMvc.perform(get("/api/lastprice?brandId={brandIdSearch}&productId={productIdSearch}&datetime={datetimeSearch}", brandIdSearch, productIdSearch, datetimeSearch)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(price.getId()))
                .andExpect(jsonPath("$.brandId").value(price.getBrandId()))
                .andExpect(jsonPath("$.priceList").value(price.getPriceList()))
                .andExpect(jsonPath("$.productId").value(price.getProductId()))
                .andExpect(jsonPath("$.price").value(price.getPrice()))
                .andExpect(jsonPath("$.currency").value(price.getCurrency()))
                .andDo(print());
    }
}
