package com.victorlevin.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StocksPricesDto {
    private List<StockPrice> prices;
}
