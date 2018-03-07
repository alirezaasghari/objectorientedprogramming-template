package oop.pset2.burgerhouse.controller.cook;

import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dish;
import oop.pset2.burgerhouse.model.dish.Meat;

public class MeatCook implements Cook {

    @Override
    public Dish cook(Order order) {
        return new Meat(order.getName());
    }

    @Override
    public String getType() {
        return "meat";
    }
}
