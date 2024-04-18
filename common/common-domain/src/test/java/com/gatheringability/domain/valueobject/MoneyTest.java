package com.gatheringability.domain.valueobject;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    Money _moneyIsZero = new Money(new BigDecimal("0.0"));
    Money _moneyIsLessThanZero = new Money(BigDecimal.valueOf(-50.0));
    Money _moneyIsGreaterThanZero = new Money(BigDecimal.valueOf(50.0));

    @Test
    public void testIsGreaterThanZero() {
        assertFalse(_moneyIsZero.isGreaterThanZero(), "Money value of 0.00 should not be greater than zero");
        assertFalse(_moneyIsLessThanZero.isGreaterThanZero(), "Money value of -50 should not be greater than zero");
        assertTrue(_moneyIsGreaterThanZero.isGreaterThanZero(), "Money value of 50 should be greater than zero");
    }

    @Test
    public void testIsGreaterThan() {
        assertTrue(_moneyIsGreaterThanZero.isGreaterThan(_moneyIsZero),
                "Money value of 50 should be greater than zero");
        assertTrue(_moneyIsZero.isGreaterThan(_moneyIsLessThanZero),
                "Money value of 0 should be greater than -50");
        assertFalse(_moneyIsZero.isGreaterThan(_moneyIsZero),
                "Money value cannot be greater than itself (0.0 should equal 0.0)");
    }

    // and so on for for add, subtract, etc.
}
