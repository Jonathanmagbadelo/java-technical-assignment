package kata.supermarket;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HalfPriceKiloDiscountTest {

    @ParameterizedTest
    @MethodSource
    void itemByWeightHasExpectedOneKiloForHalfPriceDiscountApplied(String pricePerKilo, String weightInKilos, String expectedPrice) {
        final ItemByWeight itemByUnit = new ItemByWeight(new BigDecimal(pricePerKilo), new BigDecimal(weightInKilos));
        final HalfPriceKiloDiscount discount = new HalfPriceKiloDiscount();
        assertEquals(new BigDecimal(expectedPrice), discount.getTotal(itemByUnit));
    }

    static Stream<Arguments> itemByWeightHasExpectedOneKiloForHalfPriceDiscountApplied() {
        return Stream.of(
                Arguments.of("50.00", "0.5", "25.00"),
                Arguments.of("100.00", "2", "100.00"),
                Arguments.of("50.00", "0", "0.00"),
                Arguments.of("100.00", "2.25", "125.00")
        );
    }
}
