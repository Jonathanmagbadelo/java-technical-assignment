# Notes

Please add here any notes, assumptions and design decisions that might help us understand your thought process.

The current initial implementation assumes that no discounts will be made at checkout.
With the current coupling between classes, the open/close principle would be violated in order to add additional logic to deal with different discount schemes.
Given discounts share the same outcome but with different schemes, the strategy pattern would be applicable. Firstly we'll create a `Discount` interface with a getTotal method and consolidate the product/item classes to decouple them.

Given the distinct difference between unit based items and weight based items and their 1-1 mapping to discount types (assumed simple case) lets create a basket interface and impl unit/weighted baskets.

Given the separation, we now need a checkout class to get the grand total. The combination of this and the abstract factory pattern above allows for easier extension of basket types.

Now we can create one discount scheme per basket:
- the two for one discount
- half price per kilo (here the assumption is that the kilo of item come from the same item class - a group of one type :)

With more time (have spent 1.5/2 hours) I would:
- If I were to implement more discounts I would utilise the factory pattern to create discount instances per item type.
- On top of that, one may have to deal with competing discounts and for that, utilising the composite pattern would allow for returning the best discount scheme given an item.
- Another extension would deal with item groups. So that discounts can be applied to more than one item type if applicable (any 3 for two, any vegetables for a kilo at half price, etc)
- Add more test coverage for baskets to test the discounts being applied across the checkout :)