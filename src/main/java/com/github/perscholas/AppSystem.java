package com.github.perscholas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppSystem extends TheSystem {
	private HashMap<String, Item> itemCollection;
	private Item item;

	AppSystem() throws IOException {

	}

	@Override
	public void display() {
		itemCollection = super.getItemCollection();
		System.out.println("AppSystem Inventory:");

		System.out.format("%-20s %-20s %-10s %-10s%n", "Name", "Description", "Price", "Available Quantity");

		for(Map.Entry<String, Item> entry : itemCollection.entrySet()) {
			System.out.format("%-20s %-20s %-10.2f %-10d%n", entry.getKey(), entry.getValue().getItemDesc(), entry.getValue().getItemPrice(), entry.getValue().getAvailableQuantity());


    /*
        System.out.printf("%-20s","Name");
        System.out.printf("%-20s","Description");
        System.out.printf("%-10s","Price");
        System.out.printf("%-10s%n","Available Quantity");

        for(Map.Entry<String, Item> entry : itemCollection.entrySet()) {

                System.out.printf("%-20s", entry.getKey());
                System.out.printf("%-20s", entry.getValue().getItemDesc());
                System.out.printf("%-10.2f", entry.getValue().getItemPrice());
                System.out.printf("%-10d%n", entry.getValue().getAvailableQuantity());

                */
		}
	}

	@Override      // this overwrites the parents class add method
	public Boolean add(Item item) {
		if(item == null) {
			return false;
		}
		if(getItemCollection().containsKey(item.getItemName())){
			System.out.println(item.getItemName() + " is already in the App System");
			return false;
		}
		getItemCollection().put(item.getItemName(), item);
		return true;
	}



	public Item reduceAvailableQuantity(String itemName) {

		if(getItemCollection().containsKey(itemName)) {
			Item item = getItemCollection().get(itemName);
			item.setAvailableQuantity(item.getAvailableQuantity()-1);
			if(item.getAvailableQuantity() < 1) {
				getItemCollection().remove(itemName);
			}
			return item;
		}
		return null;
	}
}
