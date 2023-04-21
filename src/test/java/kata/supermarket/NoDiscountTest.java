package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoDiscountTest {

    @Test
    void noDiscountShouldReturnOriginalItemByUnitPrice(){
        ItemByUnit itemByUnit = new ItemByUnit(new BigDecimal("2.00"), new BigDecimal("1"));
        NoDiscount discount = new NoDiscount();
        assertEquals(itemByUnit.price(), discount.getTotal(itemByUnit));
    }


    @Test
    void noDiscountShouldReturnOriginalItemByWeightPrice(){
        ItemByWeight itemByWeight = new ItemByWeight(new BigDecimal("3.00"), new BigDecimal("0.5"));
        NoDiscount discount = new NoDiscount();
        assertEquals(itemByWeight.price(), discount.getTotal(itemByWeight));
    }
}
