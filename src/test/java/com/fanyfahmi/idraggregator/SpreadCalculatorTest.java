package com.fanyfahmi.idraggregator;

import com.fanyfahmi.idraggregator.util.SpreadCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpreadCalculatorTest {

    @Test
    void testCalculateFactor_FanyFahmi() {
        String username = "fanyfahmi";
        double expected = 0.00947;
        double actual = SpreadCalculator.calculateFactor(username);

        Assertions.assertEquals(expected, actual, 0.000001, "Spread factor harus 0.00947 untuk fanyfahmi");
    }
}
