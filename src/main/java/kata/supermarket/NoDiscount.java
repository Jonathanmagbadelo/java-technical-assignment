package kata.supermarket;

import java.math.BigDecimal;

public class NoDiscount implements Discount<Item>{
    @Override
    public BigDecimal getTotal(Item item) {
        return item.price();
    }
}
