/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lokey.onlineshopping;

/**
 *
 * @author ADMIN
 */
public class OrderItem {
    private static int _id = 0;
    private int id;
    private Product item;
    private int quantity;

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", item=" + item + ", quantity=" + quantity + '}';
    }

    public OrderItem() {
        this.id = ++_id;
        this.item = new Product();
        this.quantity = 0;
    }

    public OrderItem( Product item, int quantity) {
        this.id = ++_id;
        this.item = item;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
