package kata.supermarket;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class ItemByWeight implements Item {

    private final BigDecimal pricePerKilo;
    private final BigDecimal weightInKilos;

    ItemByWeight(final BigDecimal pricePerKilo, final BigDecimal weightInKilos) {
        this.pricePerKilo = pricePerKilo;
        this.weightInKilos = weightInKilos;
    }

    public BigDecimal price() {
        return pricePerKilo.multiply(weightInKilos).setScale(2, HALF_UP);
    }
}
