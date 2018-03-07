package oop.pset2.burgerhouse.controller;

import oop.pset2.burgerhouse.controller.cook.*;
import oop.pset2.burgerhouse.model.Order;
import oop.pset2.burgerhouse.model.dish.Dish;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KitchenManager {

    private Set<Cook> cooks = Stream.of(
            new PizzaCook(),
            new BurgerCook(),
            new MeatCook(),
            new DessertCook(),
            new SoupCook(),
            new SaladCook()
    ).collect(Collectors.toSet());

    public List<Dish> cook(List<Order> orders) {
        return orders.stream()
                .map(cookDish())
                .filter(dish -> dish.isPresent())
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Function<Order, Optional<Dish>> cookDish() {
        return order -> {
            return cooks.stream()
                    .filter(cook -> cook.getType().equals(order.getType()))
                    .map(cook -> cook.cook(order))
                    .findFirst();
        };
    }
}
