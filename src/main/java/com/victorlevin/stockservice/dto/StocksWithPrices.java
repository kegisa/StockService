package com.victorlevin.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StocksWithPrices {
    List<StockWithPrice> stocks;
}
