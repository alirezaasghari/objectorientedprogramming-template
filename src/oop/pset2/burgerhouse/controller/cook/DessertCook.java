package oop.pset2.burgerhouse.controller.cook;

import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dessert;
import oop.pset2.burgerhouse.model.dish.Dish;

public class DessertCook implements Cook {

    @Override
    public Dish cook(Order order) {
        return new Dessert(order.getName());
    }

    @Override
    public String getType() {
        return "dessert";
    }
}
