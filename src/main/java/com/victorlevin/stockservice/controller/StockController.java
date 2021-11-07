package com.victorlevin.stockservice.controller;

import com.victorlevin.stockservice.dto.StocksDto;
import com.victorlevin.stockservice.dto.StocksWithPrices;
import com.victorlevin.stockservice.dto.TickersDto;
import com.victorlevin.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping("/getByTickers")
    public StocksDto getStocksByTickers(@RequestBody TickersDto tickersDto) {
        return stockService.getStocksByTickers(tickersDto);
    }

    @PostMapping("/prices")
    public StocksWithPrices getPrices(@RequestBody StocksDto stocksDto) {
        return stockService.getPrices(stocksDto);
    }
}
