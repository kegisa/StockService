package com.victorlevin.stockservice.service;

import com.victorlevin.stockservice.dto.StocksDto;
import com.victorlevin.stockservice.dto.TickersDto;
import com.victorlevin.stockservice.exception.StockNotFoundException;
import com.victorlevin.stockservice.feignclient.MoexServiceClient;
import com.victorlevin.stockservice.feignclient.TinkoffServiceClient;
import com.victorlevin.stockservice.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {
    private final TinkoffServiceClient tinkoffService;
    private final MoexServiceClient moexService;

    public StocksDto getStocksByTickers(TickersDto tickersDto) {
        List<Stock> resultList = new ArrayList<>();
        List<String> tickers = new ArrayList<>(tickersDto.getTickers());
        List<Stock> stocksFromTinkoff = tinkoffService.getStocksByTickers(tickersDto).getStocks();
        resultList.addAll(stocksFromTinkoff);
        List<String> tickersFromTinkoff = stocksFromTinkoff.stream().map(s -> s.getTicker()).collect(Collectors.toList());
        tickers.removeAll(tickersFromTinkoff);

        if(!tickers.isEmpty()) {
            List<Stock> stocksFromMoex = moexService.getStocksByTickers(new TickersDto(tickers)).getStocks();
            List<String> tickerFromMoex = stocksFromMoex.stream().map(s -> s.getTicker()).collect(Collectors.toList());
            tickers.removeAll(tickerFromMoex);
            if(!tickers.isEmpty()) {
                throw new StockNotFoundException(String.format("Tickers % not found.", tickers));
            }
            resultList.addAll(stocksFromMoex);
        }

        return new StocksDto(resultList);
    }
}
