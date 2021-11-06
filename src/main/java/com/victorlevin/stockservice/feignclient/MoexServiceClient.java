package com.victorlevin.stockservice.feignclient;

import com.victorlevin.stockservice.dto.StocksDto;
import com.victorlevin.stockservice.dto.TickersDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "moexservice", url = "${api.moexConfig.moexService}", configuration = FeignConfig.class)
public interface MoexServiceClient {
    @PostMapping("${api.moexConfig.getStocksByTickers}")
    StocksDto getStocksByTickers(TickersDto tickersDto);
}
