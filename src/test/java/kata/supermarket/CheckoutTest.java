package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest {

    @Test
    void checkoutHasExpectedBasketTotal() {
        Checkout checkout = new Checkout();
        BasketForItemsByUnit basketForItemsByUnit = new BasketForItemsByUnit();
        BasketForItemsByWeight basketForItemsByWeight = new BasketForItemsByWeight();

        // add items
        ItemByUnit itemByUnit = new ItemByUnit(new BigDecimal("2.00"), new BigDecimal("1"));
        ItemByWeight itemByWeight = new ItemByWeight(new BigDecimal("3.00"), new BigDecimal("0.5"));

        basketForItemsByUnit.add(itemByUnit);
        basketForItemsByWeight.add(itemByWeight);

        BigDecimal expectedCheckoutTotal = itemByUnit.price().add(itemByWeight.price());

        assertEquals(expectedCheckoutTotal, checkout.getGrandTotal(List.of(basketForItemsByUnit, basketForItemsByWeight)));
    }
}
