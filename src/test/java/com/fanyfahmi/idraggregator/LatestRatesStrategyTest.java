package com.fanyfahmi.idraggregator;

import com.fanyfahmi.idraggregator.service.strategy.LatestRatesStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class LatestRatesStrategyTest {

    @Mock
    private Map<String, Object> internalStorage;

    @InjectMocks
    private LatestRatesStrategy strategy;

    @Test
    void testGetCachedData_Success() {

        Map<String, Object> mockData = Map.of("base", "IDR", "USD_BuySpread_IDR", 0.000067);

        when(internalStorage.get("latest_idr_rates")).thenReturn(mockData);

        Object result = strategy.getCachedData();

        assertEquals(mockData, result);
        assertEquals("latest_idr_rates", strategy.getResourceType());
    }
}
