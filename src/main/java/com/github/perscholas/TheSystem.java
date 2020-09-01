package com.github.perscholas;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;




public abstract class TheSystem {
	private HashMap<String, Item> itemCollection; //list of items in system or cart, depending

	TheSystem() throws IOException {
		itemCollection = new HashMap<>();
		if (getClass().getSimpleName().equals("AppSystem")) {
			itemCollection = sampleCollection();

		}
	}
	public HashMap<String, Item> sampleCollection() {

		Map<String, Item> mapFromFile = getHashMapFromFile();

		return (HashMap)mapFromFile;
	}

	public static Map<String, Item> getHashMapFromFile(){

		Map<String, Item> mapFileTextCollection = new HashMap<String, Item>();
		BufferedReader br = null;

		try{

			File file = new File("src//main//resources//sample.txt");

			br = new BufferedReader( new FileReader(file) );

			String line = null;

			while ( (line = br.readLine()) != null ){

				String[] itemInfo = line.split("  ", 4);

				Item item = new Item();

				item.setItemName(itemInfo[0].trim());
				item.setItemDesc(itemInfo[1].trim());
				item.setItemPrice(Double.valueOf(itemInfo[2]));
				item.setAvailableQuantity(Integer.valueOf(itemInfo[3]));


				if( !item.getItemName().equals("") && !item.getItemDesc().equals("")
						&& !item.getItemPrice().equals("") && !item.getAvailableQuantity().equals(""))
					mapFileTextCollection.put(itemInfo[0], item);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{

			if(br != null){
				try {
					br.close();
				}catch(Exception e){};
			}
		}
		return mapFileTextCollection;
	}



	public HashMap<String, Item> getItemCollection(){
		return itemCollection;
	}



	public Boolean checkAvailability(Item item) {
		if(item.getQuantity() > item.getAvailableQuantity()) {
			System.out.println("System is unable to add " + item.getItemName() +
					" to the cart. System only has " + item.getAvailableQuantity() + " "
					+ item.getItemName() + "s.");
			return false;
		}
		return true;
	}



	public Boolean add(Item item) {  //adds to cart
		if(item == null) {
			return false;
		}
		if(itemCollection.containsKey(item.getItemName()) && item.getAvailableQuantity() > 0) {
			item.setQuantity(item.getQuantity() + 1);
			return true;
		}
		if(!itemCollection.containsKey(item.getItemName())) {
			itemCollection.put(item.getItemName(), item);
			return true;
		}
		return false;
	}



	public Item remove(String itemName) {
		if(getItemCollection().containsKey(itemName)) {
			Item ghostCollection = itemCollection.get(itemName);
			itemCollection.remove(itemName);
			System.out.println(itemName + " removed");
			return ghostCollection;
		} else {
			return null;
		}
	}

	public abstract void display();
}