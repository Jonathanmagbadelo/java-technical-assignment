package kata.supermarket;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal getTotal(Item item);

}
