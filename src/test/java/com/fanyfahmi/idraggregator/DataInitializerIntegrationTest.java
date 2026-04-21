package com.fanyfahmi.idraggregator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class DataInitializerIntegrationTest {

    @Autowired
    private Map<String, Object> internalStorage;

    @Test
    void testDataIsLoadedAfterStartup() {
        Assertions.assertNotNull(internalStorage.get("latest_idr_rates"));
        Assertions.assertNotNull(internalStorage.get("historical_idr_usd"));
        Assertions.assertNotNull(internalStorage.get("supported_currencies"));
    }
}
