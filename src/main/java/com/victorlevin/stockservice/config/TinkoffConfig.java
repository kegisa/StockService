package com.victorlevin.stockservice.config;

import lombok.Data;

@Data
public class TinkoffConfig {
    private String tinkoffService;
    private String getStocksByTickers;
}
