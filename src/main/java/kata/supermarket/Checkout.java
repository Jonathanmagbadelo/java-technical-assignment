package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Checkout {

    public BigDecimal getGrandTotal(List<Basket<? extends Item>> baskets) {
        return baskets.stream().map(Basket::total)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
