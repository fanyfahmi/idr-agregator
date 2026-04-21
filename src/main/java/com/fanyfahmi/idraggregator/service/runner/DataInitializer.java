package com.fanyfahmi.idraggregator.service.runner;

import com.fanyfahmi.idraggregator.util.SpreadCalculator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class DataInitializer implements ApplicationRunner {

    private final WebClient webClient;
    private final Map<String, Object> internalStorage;

    public DataInitializer(WebClient webClient, Map<String, Object> internalStorage) {
        this.webClient = webClient;
        this.internalStorage = internalStorage;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Memulai proses pre-fetching data...");

        try {
            Map<String, Object> latestRates = webClient.get()
                    .uri("/latest?base=IDR")
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            processLatestRates(latestRates);

        } catch (Exception e) {
            System.err.println("Gagal fetch latest rates: " + e.getClass().getName() + " - " + e.getMessage());
        }

        try {
            Object historical = webClient.get()
                    .uri("/2024-01-01..2024-01-05?from=IDR&to=USD")
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();

            internalStorage.put("historical_idr_usd", historical);

        } catch (Exception e) {
            System.err.println("Gagal fetch historical rates: " + e.getClass().getName() + " - " + e.getMessage());
        }

        try {
            Object currencies = webClient.get()
                    .uri("/currencies")
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();

            internalStorage.put("supported_currencies", currencies);

        } catch (Exception e) {
            System.err.println("Gagal fetch supported currencies: " + e.getClass().getName() + " - " + e.getMessage());
        }

        System.out.println("Data berhasil dimuat ke memori.");
    }

    private void processLatestRates(Map<String, Object> data) {

        try {
            Map<String, Double> rates = (Map<String, Double>) data.get("rates");
            Double rateUsd = rates.get("USD");

            double factor = SpreadCalculator.calculateFactor("fanyfahmi");
            double buySpread = (1 / rateUsd) * (1 + factor);

            data.put("USD_BuySpread_IDR", buySpread);

            internalStorage.put("latest_idr_rates", data);
        } catch (Exception e) {
            System.err.println("Gagal memproses data rates: " + e.getMessage());
        }

    }
}
