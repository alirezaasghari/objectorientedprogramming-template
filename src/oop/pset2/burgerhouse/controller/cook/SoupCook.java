package oop.pset2.burgerhouse.controller.cook;

import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Burger;
import oop.pset2.burgerhouse.model.dish.Dish;

public class SoupCook implements Cook {

    @Override
    public Dish cook(Order order) {
        return new Burger(order.getName());
    }

    @Override
    public String getType() {
        return "soup";
    }
}
