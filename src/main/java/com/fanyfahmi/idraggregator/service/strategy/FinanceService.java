package com.fanyfahmi.idraggregator.service.strategy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FinanceService {
    private final Map<String, IdrDataFetcher> strategies;

    public FinanceService(List<IdrDataFetcher> strategyList) {
        this.strategies = strategyList.stream().collect(Collectors.toMap(IdrDataFetcher::getResourceType, s -> s));
    }

    public Object getFinanceData(String resourceType) {
        IdrDataFetcher strategy = strategies.get(resourceType);
        if (strategy == null) {
            throw new IllegalArgumentException("Type tidak valid");
        }
        return strategy.getCachedData();
    }
}
