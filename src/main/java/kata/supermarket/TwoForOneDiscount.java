package kata.supermarket;

import java.math.BigDecimal;

public class TwoForOneDiscount implements Discount<ItemByUnit> {
    @Override
    public BigDecimal getTotal(ItemByUnit item) {
        int twoForOneCount = item.getUnitCount().intValue() / 2;
        int singleCount = item.getUnitCount().intValue() % 2;

        BigDecimal twoForOneTotal = item.getPricePerUnit().multiply(new BigDecimal(twoForOneCount));
        BigDecimal singleTotal = item.getPricePerUnit().multiply(new BigDecimal(singleCount));

        return twoForOneTotal.add(singleTotal);
    }
}
