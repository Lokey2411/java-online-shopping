/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lokey.onlineshopping;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Order {
    private static int _id = 0;
    private int id;
    private Date orderDate;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private double totalAmount = 0;
    private boolean status = false;
    private List<OrderItem> itemList;

    public Order() {
        this.id = ++_id;
        this.orderDate = new Date();
        this.customerAddress = "USA";
        this.customerName = "";
        this.customerPhone = "0000000000";
        
    }

    public Order(String customerName, String customerPhone, String customerAddress, List<OrderItem> itemList) {
        this.id = ++_id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.orderDate = new Date();
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    
    
    public void calculateTotalAmout(){
        final int n = itemList.size();
        double total = 0;
        for(int i=0;i<n;i++){
            total+=itemList.get(i).getItem().getPrd_price()*itemList.get(i).getQuantity();
        }
        setTotalAmount( total);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderDate=" + orderDate + ", customerName=" + customerName + ", customerPhone=" + customerPhone + ", customerAddress=" + customerAddress + ", totalAmount=" + totalAmount + ", status=" + status + ", itemList=" + itemList + '}';
    }
}
