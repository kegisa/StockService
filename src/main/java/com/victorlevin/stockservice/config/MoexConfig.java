package com.victorlevin.stockservice.config;

import lombok.Data;

@Data
public class MoexConfig {
    private String moexService;
    private String getStocksByTickers;
}
