package com.fanyfahmi.idraggregator.service.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SupportedCurrenciesStrategy implements IdrDataFetcher {

    private final Map<String, Object> internalStorage;

    public SupportedCurrenciesStrategy(Map<String, Object> internalStorage) {
        this.internalStorage = internalStorage;
    }

    @Override
    public String getResourceType() {
        return "supported_currencies";
    }

    @Override
    public Object getCachedData() {
        return internalStorage.get(getResourceType());
    }
}
