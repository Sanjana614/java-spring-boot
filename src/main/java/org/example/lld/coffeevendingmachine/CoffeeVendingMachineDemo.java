package org.example.lld.coffeevendingmachine;

import org.assertj.core.util.Maps;
import org.example.lld.coffeevendingmachine.enums.CoffeeType;
import org.example.lld.coffeevendingmachine.enums.Ingredient;
import org.example.lld.coffeevendingmachine.enums.ToppingType;

import java.util.*;

public class CoffeeVendingMachineDemo {
    public static void main(String[] args) {
        CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();
        Inventory inventory = new Inventory();
        // --- Initial setup: Refill inventory ---
        System.out.println("=== Initializing Vending Machine ===");
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.COFFEE_BEANS, 50);
        ingredients.put(Ingredient.WATER, 500);
        ingredients.put(Ingredient.MILK, 200);
        ingredients.put(Ingredient.SUGAR, 100);
        ingredients.put(Ingredient.CARAMEL_SYRUP, 50);
        inventory.addStock(ingredients);
        machine.setInventory(inventory);
        inventory.printInventory();

        // --- Scenario 1: Successful Purchase of a Latte ---
        System.out.println("\n--- SCENARIO 1: Buy a Latte (Success) ---");
        machine.selectCoffee(CoffeeType.LATTE, Collections.emptyList());
        machine.insertMoney(200);
        machine.insertMoney(50); // Total 250, price is 220
        machine.dispenseCoffee();
        inventory.printInventory();

        // --- Scenario 2: Purchase with Insufficient Funds & Cancellation ---
        System.out.println("\n--- SCENARIO 2: Buy Espresso (Insufficient Funds & Cancel) ---");
        machine.selectCoffee(CoffeeType.ESPRESSO, Collections.emptyList());
        machine.insertMoney(100); // Price is 150
        machine.dispenseCoffee(); // Should fail
        machine.cancel(); // Should refund 100
        inventory.printInventory(); // Should be unchanged

        // --- Scenario 3: Attempt to Buy with Insufficient Ingredients ---
        System.out.println("\n--- SCENARIO 3: Buy Cappuccino (Out of Milk) ---");
        inventory.printInventory();
        machine.selectCoffee(CoffeeType.CAPPUCCINO, Arrays.asList(ToppingType.CARAMEL_SYRUP, ToppingType.EXTRA_SUGAR));
        machine.insertMoney(300);
        machine.dispenseCoffee(); // Should fail and refund
        inventory.printInventory();

        // --- Refill and final test ---
        System.out.println("\n--- REFILLING AND FINAL TEST ---");
        inventory.addStock(Maps.newHashMap(Ingredient.MILK, 200));
        inventory.printInventory();
        machine.selectCoffee(CoffeeType.LATTE, Arrays.asList(ToppingType.CARAMEL_SYRUP));
        machine.insertMoney(250);
        machine.dispenseCoffee();
        inventory.printInventory();

    }
}
