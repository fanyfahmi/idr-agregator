package com.fanyfahmi.idraggregator.util;

public class SpreadCalculator {
    public static double calculateFactor(String username) {
        int sum = username.toLowerCase().chars().sum();
        return (sum % 1000) / 100000.0;
    }
}
