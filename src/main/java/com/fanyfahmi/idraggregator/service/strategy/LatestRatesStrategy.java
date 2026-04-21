package com.fanyfahmi.idraggregator.service.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LatestRatesStrategy implements IdrDataFetcher {

    private final Map<String, Object> internalStorage;

    public LatestRatesStrategy(Map<String, Object> internalStorage) {
        this.internalStorage = internalStorage;
    }

    @Override
    public String getResourceType() {
        return "latest_idr_rates";
    }

    @Override
    public Object getCachedData() {
        return internalStorage.get(getResourceType());
    }
}
