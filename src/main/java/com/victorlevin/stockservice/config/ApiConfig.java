package com.victorlevin.stockservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "api")
public class ApiConfig {
    private TinkoffConfig tinkoffConfig;
    private MoexConfig priceServiceConfig;
}
