package org.example.lld.coffeevendingmachine;

import org.example.lld.coffeevendingmachine.decorator.CaramelSyrupCoffeeDecorator;
import org.example.lld.coffeevendingmachine.decorator.ExtraSugarCoffeeDecorator;
import org.example.lld.coffeevendingmachine.enums.CoffeeType;
import org.example.lld.coffeevendingmachine.enums.Ingredient;
import org.example.lld.coffeevendingmachine.enums.ToppingType;
import org.example.lld.coffeevendingmachine.factory.CoffeeFactory;
import org.example.lld.coffeevendingmachine.state.ReadyState;
import org.example.lld.coffeevendingmachine.state.VendingMachineState;
import org.example.lld.coffeevendingmachine.templatemethod.Coffee;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CoffeeVendingMachine {
    private static volatile CoffeeVendingMachine instance;
    private Inventory inventory;
    private VendingMachineState currentState;
    private Coffee selectedCoffee;
    private int moneyInserted;

    private CoffeeVendingMachine() {
        this.currentState = new ReadyState();
    }

    public static CoffeeVendingMachine getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (CoffeeVendingMachine.class) {
                if (Objects.isNull(instance)) {
                    instance = new CoffeeVendingMachine();
                }
            }
        }
        return instance;
    }

    public void selectCoffee(CoffeeType coffeeType, List<ToppingType> toppings) {
        Coffee coffee = CoffeeFactory.getCoffee(coffeeType);
        for (ToppingType toppingType : toppings) {
            switch (toppingType) {
                case EXTRA_SUGAR:
                    coffee = new ExtraSugarCoffeeDecorator(coffee);
                    break;
                case CARAMEL_SYRUP:
                    coffee = new CaramelSyrupCoffeeDecorator(coffee);
                    break;
            }
        }
        this.currentState.selectCoffee(this, coffee);
    }

    public void insertMoney(int amount) {
        this.currentState.addPayment(this, amount);
    }

    public void dispenseCoffee() {
        this.currentState.dispenseCoffee(this);
    }

    public void cancel() {
        this.currentState.cancel(this);
    }

    public void addIngredients(Map<Ingredient, Integer> ingredients) {
        inventory.addStock(ingredients);
    }

    public void reset() {
        this.currentState = new ReadyState();
        this.moneyInserted = 0;
        this.selectedCoffee = null;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMoneyInserted() {
        return moneyInserted;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public synchronized void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    public void setSelectedCoffee(Coffee coffee) {
        this.selectedCoffee = coffee;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }
}
