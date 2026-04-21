package com.fanyfahmi.idraggregator.service.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HistoricalDataStrategy implements IdrDataFetcher {

    private final Map<String, Object> internalStorage;

    public HistoricalDataStrategy(Map<String, Object> internalStorage) {
        this.internalStorage = internalStorage;
    }

    @Override
    public String getResourceType() {
        return "historical_idr_usd";
    }

    @Override
    public Object getCachedData() {
        return internalStorage.get(getResourceType());
    }
}
