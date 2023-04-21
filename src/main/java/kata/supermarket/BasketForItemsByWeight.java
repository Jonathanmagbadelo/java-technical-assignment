package kata.supermarket;

public class BasketForItemsByWeight extends Basket<ItemByWeight> {
    public BasketForItemsByWeight() {
        setDiscount(new HalfPriceKiloDiscount());
    }
}
