package kata.supermarket;

import java.math.BigDecimal;

public interface Discount<T extends Item> {

    BigDecimal getTotal(T item);

}
