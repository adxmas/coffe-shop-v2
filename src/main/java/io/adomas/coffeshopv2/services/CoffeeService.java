package io.adomas.coffeshopv2.services;

import io.adomas.coffeshopv2.model.Coffee;

import java.util.List;

public interface CoffeeService {

    Coffee createCofee(Coffee coffee);

    Coffee updateCoffee(Coffee coffee);

    List<Coffee> getAllCoffees();

    Coffee getCofeeById(int coffeeId);

    void deleteCoffee(int coffeeId);

    void deleteAllCoffees();
}
