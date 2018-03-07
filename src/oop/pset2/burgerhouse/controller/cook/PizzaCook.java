package oop.pset2.burgerhouse.controller.cook;

import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dish;
import oop.pset2.burgerhouse.model.dish.Pizza;

public class PizzaCook implements Cook {

    @Override
    public Dish cook(Order order) {
        return new Pizza(order.getName());
    }

    @Override
    public String getType() {
        return "pizza";
    }
}
