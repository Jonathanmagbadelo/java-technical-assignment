package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketForItemsByUnitTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<ItemByUnit> items) {
        final BasketForItemsByUnit basket = new BasketForItemsByUnit();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noUnitItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit()
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noUnitItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static ItemByUnit aPintOfMilk() {
        return new ItemByUnit(new BigDecimal("0.49"), new BigDecimal(1));
    }

    private static ItemByUnit aPackOfDigestives() {
        return new ItemByUnit(new BigDecimal("1.55"), new BigDecimal(1));
    }


}