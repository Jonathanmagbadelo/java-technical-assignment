# Notes

Please add here any notes, assumptions and design decisions that might help us understand your thought process.

The current initial implementation assumes that no discounts will be made at checkout.
With the current coupling between classes, the open/close principle would be violated in order to add additional logic to deal with different discount schemes.
Given discounts share the same outcome but with different schemes, the strategy pattern would be applicable. Firstly we'll create a `Discount` interface with a getTotal method and consolidate the product/item classes to decouple them.
