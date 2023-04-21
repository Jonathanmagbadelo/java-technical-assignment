package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Basket<T extends Item> {
    List<T> items = new ArrayList<>();

    public BigDecimal total() {
        return getItems().stream().map(T::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public void add(final T item) {
        this.items.add(item);
    }

    List<T> getItems() {
        return Collections.unmodifiableList(items);
    }

}
