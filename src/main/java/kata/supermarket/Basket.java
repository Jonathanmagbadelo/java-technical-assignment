package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Basket<T extends Item> {
    List<T> items = new ArrayList<>();
    Discount<Item> discount = new NoDiscount(); // default to no discount applied

    public BigDecimal total() {
        return getItems().stream().map(discount::getTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public void add(final T item) {
        this.items.add(item);
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    List<T> getItems() {
        return Collections.unmodifiableList(items);
    }

}
