package com.github.perscholas;

public class Item{
    private String itemName; //name of the item
    private String itemDesc; //item's description
    private Double itemPrice; //item's price as a double
    private Integer quantity; // # of items added to cart
    private Integer availableQuantity; //# of items of type in system

    public Item() {
        this.quantity = 1;
    }

    public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.availableQuantity = availableQuantity;
        this.quantity = 1;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc){
        this.itemDesc = itemDesc;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice){
        this.itemPrice = itemPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}