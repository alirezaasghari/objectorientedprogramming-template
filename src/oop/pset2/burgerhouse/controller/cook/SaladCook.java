package oop.pset2.burgerhouse.controller.cook;

import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dish;
import oop.pset2.burgerhouse.model.dish.Salad;

public class SaladCook implements Cook {

    @Override
    public Dish cook(Order order) {
        return new Salad(order.getName());
    }

    @Override
    public String getType() {
        return "salad";
    }
}
