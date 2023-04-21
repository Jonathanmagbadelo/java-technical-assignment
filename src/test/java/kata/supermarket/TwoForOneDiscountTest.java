package kata.supermarket;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoForOneDiscountTest {

    @ParameterizedTest
    @MethodSource
    void itemByUnitHasExpectedTwoForOneDiscountApplied(String pricePerUnit, String unitCount, String expectedPrice) {
        final ItemByUnit itemByUnit = new ItemByUnit(new BigDecimal(pricePerUnit), new BigDecimal(unitCount));
        final TwoForOneDiscount discount = new TwoForOneDiscount();
        assertEquals(new BigDecimal(expectedPrice), discount.getTotal(itemByUnit));
    }

    static Stream<Arguments> itemByUnitHasExpectedTwoForOneDiscountApplied() {
        return Stream.of(
                Arguments.of("50.00", "2", "50.00"),
                Arguments.of("100.00", "1", "100.00"),
                Arguments.of("50.00", "0", "0.00"),
                Arguments.of("100.00", "5", "300.00")
        );
    }
}
