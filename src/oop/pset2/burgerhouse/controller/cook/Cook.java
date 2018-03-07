package oop.pset2.burgerhouse.controller.cook;

import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dish;

public interface Cook {

    Dish cook(Order order);

    String getType();

}
