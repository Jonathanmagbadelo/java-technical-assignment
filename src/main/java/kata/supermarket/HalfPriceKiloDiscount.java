package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HalfPriceKiloDiscount implements Discount<ItemByWeight> {
    @Override
    public BigDecimal getTotal(ItemByWeight item) {
        BigDecimal pricePerKilo = item.getPricePerKilo();
        BigDecimal weightInKilos = item.getWeightInKilos();

        if (weightInKilos.compareTo(BigDecimal.ZERO) <= 0) {
            return new BigDecimal("0.00");
        }

        BigDecimal[] kilosAndRemainder = weightInKilos.divideAndRemainder(BigDecimal.ONE);
        BigDecimal wholeKilos = kilosAndRemainder[0];
        BigDecimal partialKilo = kilosAndRemainder[1];

        // treat whole kilos as half from a pricing standpoint
        BigDecimal wholeKilosPrice = pricePerKilo.multiply(wholeKilos).multiply(new BigDecimal("0.5"));
        BigDecimal partialKiloPrice = pricePerKilo.multiply(partialKilo);

        return wholeKilosPrice.add(partialKiloPrice).setScale(2, RoundingMode.HALF_UP);
    }
}
