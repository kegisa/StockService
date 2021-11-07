package com.victorlevin.stockservice.feignclient;

import com.victorlevin.stockservice.dto.FigiesDto;
import com.victorlevin.stockservice.dto.StocksDto;
import com.victorlevin.stockservice.dto.StocksPricesDto;
import com.victorlevin.stockservice.dto.TickersDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "tinkoffservice", url = "${api.tinkoffConfig.tinkoffService}", configuration = FeignConfig.class)
public interface TinkoffServiceClient extends ApiStockService {
    @PostMapping("${api.tinkoffConfig.getStocksByTickers}")
    StocksDto getStocksByTickers(TickersDto tickersDto);

    @PostMapping("${api.tinkoffConfig.getPrices}")
    StocksPricesDto getPrices(FigiesDto figiesDto);
}
