package oop.pset2.burgerhouse.controller;

import oop.pset2.burgerhouse.model.Menu;
import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dish;
import oop.pset2.burgerhouse.view.Waiter;

import java.util.List;

public class BurgerHouseRestaurant {

    private Menu menu = Management.getMenu();
    private Waiter waiter = new Waiter(menu);
    private KitchenManager kitchenManager = new KitchenManager();

    public void visit() {
        // showMenu the menu -- we need one menu
        // write orders -- waiter is giving us a list of orders
        // give orders to kitchen manager -- he gives us back a list of dishes
        // display dishes -- waiter displays the dishes


        waiter.showMenu();
        List<Order> orders = waiter.getOrders();
        List<Dish> dishes = kitchenManager.cook(orders);
        waiter.show(dishes);
    }
}
