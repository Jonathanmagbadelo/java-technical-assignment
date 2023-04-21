package kata.supermarket;

public class BasketForItemsByUnit extends Basket<ItemByUnit> {
    public BasketForItemsByUnit() {
        setDiscount(new TwoForOneDiscount());
    }
}
