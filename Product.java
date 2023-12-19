/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lokey.onlineshopping;

/**
 *
 * @author ADMIN
 */
public class Product {
    private static int id;
    private int prd_id;
    private String prd_name;
    private double prd_price;

    @Override
    public String toString() {
        return "Product{" + "prd_id=" + prd_id + ", prd_name=" + prd_name + ", prd_price=" + prd_price + '}';
    }

    public Product() {
        this.prd_id = ++id;
        this.prd_name = "";
        this.prd_price = 0;
    }

    public Product(String prd_name, double prd_price) {
        this.prd_id = ++id;
        this.prd_name = prd_name;
        this.prd_price = prd_price;
    }



    public int getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }

    public String getPrd_name() {
        return prd_name;
    }

    public void setPrd_name(String prd_name) {
        this.prd_name = prd_name;
    }

    public double getPrd_price() {
        return prd_price;
    }

    public void setPrd_price(double prd_price) {
        this.prd_price = prd_price;
    }
    
    
    
}
