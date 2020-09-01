package com.github.perscholas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartSystem extends TheSystem {
	private Double subtotal = 0.00; //sum of each price*quantity in cart


	CartSystem() throws IOException {

	}

	@Override
	public void display() {
		HashMap<String, Item> itemCollection = getItemCollection();
		System.out.println("Cart:");

		System.out.format("%-20s %-20s %-10s %-10s %-10s%n", "Name", "Description", "Price", "Quantity", "Sub Total");

		subtotal = 0.00;
		for(Map.Entry<String, Item> entry : itemCollection.entrySet()) {
			System.out.format("%-20s %-20s %-10.2f %-10d %-10.2f%n", entry.getKey(), entry.getValue().getItemDesc(), entry.getValue().getItemPrice(), entry.getValue().getQuantity(), entry.getValue().getItemPrice() * entry.getValue().getQuantity());

			subtotal += entry.getValue().getItemPrice() * entry.getValue().getQuantity();
		}

		//  System.out.format("%-20s %-20.2f%n %-20s %-20.2f%n %-20s %-20.2f%n", "Pre-tax Total", subtotal, "Tax", (subtotal * 0.05), "Total", (subtotal + (subtotal * 0.05)));

		System.out.printf("%-20s", "Pre-tax Total");
		System.out.printf("%-20.2f%n", subtotal);

		System.out.printf("%-20s", "Tax");
		System.out.printf("%-20.2f%n", (subtotal * 0.05));

		System.out.printf("%-20s", "Total");
		System.out.printf("%-20.2f%n", (subtotal + (subtotal * 0.05)));


       /*
        System.out.printf("%-20s ","Name");
        System.out.printf("%-20s ","Description");
        System.out.printf("%-10s ","Price");
        System.out.printf("%-10s ","Quantity");
        System.out.printf("%-10s%n ","Sub Total");



        for(Map.Entry<String, Item> entry : itemCollection.entrySet()) {

            System.out.printf("%-20s ", entry.getKey());
            System.out.printf("%-20s ", entry.getValue().getItemDesc());
            System.out.printf("%-10.2f ", entry.getValue().getItemPrice());
            System.out.printf("%-10d ", entry.getValue().getQuantity());
            System.out.printf("%-10.2f%n ", (entry.getValue().getItemPrice() * entry.getValue().getQuantity()));
            subtotal += entry.getValue().getItemPrice() * entry.getValue().getQuantity();
        }
        System.out.printf("%n ");
        System.out.printf("%-20s ", "Pre-tax Total");
        System.out.printf("%-20.2f%n ", subtotal);
        System.out.printf("%-20s ", "Tax");
        System.out.printf("%-20.2f%n ", subtotal * 0.05);
        System.out.printf("%-20s ", "Total");
        System.out.printf("%-20.2f%n ", subtotal + (subtotal * 0.05));
        */

	}

}