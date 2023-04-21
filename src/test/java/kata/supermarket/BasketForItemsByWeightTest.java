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

public class BasketForItemsByWeightTest {
    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<ItemByWeight> items) {
        final BasketForItemsByWeight basket = new BasketForItemsByWeight();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noWeightedItems(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments noWeightedItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static ItemByWeight twoFiftyGramsOfAmericanSweets() {
        return new ItemByWeight(new BigDecimal("4.99"), new BigDecimal(".25"));
    }

    private static ItemByWeight twoHundredGramsOfPickAndMix() {
        return new ItemByWeight(new BigDecimal("2.99"), new BigDecimal(".2"));
    }
}
