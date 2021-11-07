package com.victorlevin.stockservice.feignclient;

import com.victorlevin.stockservice.dto.FigiesDto;
import com.victorlevin.stockservice.dto.StocksDto;
import com.victorlevin.stockservice.dto.StocksPricesDto;
import com.victorlevin.stockservice.dto.TickersDto;

public interface ApiStockService {
    StocksPricesDto getPrices(FigiesDto figiesDto);
    StocksDto getStocksByTickers(TickersDto tickersDto);
}
