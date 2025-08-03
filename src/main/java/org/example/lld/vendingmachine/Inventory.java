package org.example.lld.vendingmachine;

import org.apache.commons.lang3.math.NumberUtils;
import org.example.lld.vendingmachine.exception.ItemOutOfStockException;
import org.example.lld.vendingmachine.exception.NoSuchItemExistsException;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> itemMap = new HashMap<>();
    private final Map<String, Integer> stockMap = new HashMap<>();

    public Inventory() {}

    public void addItem(String code, String name, int price, int quantity) {
        if (!itemMap.containsKey(code)) {
            itemMap.put(code, new Item(code, name, price));
        }
        stockMap.merge(code, quantity, Integer::sum);
    }

    public void reduceStock(String code) {
        int availableUnit = getStock(code);
        if (NumberUtils.INTEGER_ZERO.equals(availableUnit)) {
            throw new ItemOutOfStockException(code);
        }
        stockMap.merge(code, -1, Integer::sum);
    }

    public int getStock(String code) {
        return stockMap.getOrDefault(code, NumberUtils.INTEGER_ZERO);
    }

    public Item getItem(String code) {
        if (!itemMap.containsKey(code)) {
            throw new NoSuchItemExistsException(code);
        }
        return itemMap.get(code);
    }
}
