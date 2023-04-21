package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final BigDecimal pricePerUnit;
    private final BigDecimal unitCount;

    ItemByUnit(final BigDecimal pricePerUnit, final BigDecimal unitCount) {
        this.pricePerUnit = pricePerUnit;
        this.unitCount = unitCount;
    }

    public BigDecimal price() {
        return pricePerUnit.multiply(unitCount);
    }
}
