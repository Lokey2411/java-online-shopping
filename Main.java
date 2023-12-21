/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lokey.onlineshopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    static Queue<Order> orderList = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    static void createMenu() {
        System.out.println("Nhap ten khach hang: ");
        sc.nextLine();
        String customerName = sc.nextLine();
        System.out.println("Nhap so dien thoai khach hang: ");
        String customerPhone = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        String customerAddress = sc.nextLine();
        System.out.println("Nhap so san pham:");
        int n = sc.nextInt();
        List<OrderItem> itemList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap ten san pham: ");
            sc.nextLine();
            String prd_name = sc.nextLine();
            System.out.println("Nhap gia san pham: ");
            double prd_price = sc.nextDouble();
            Product item = new Product(prd_name, prd_price);
            System.out.println("Nhap so luong/ khoi luong san pham: ");
            int quantity = sc.nextInt();
            itemList.add(new OrderItem(item, quantity));
        }
        Order item = new Order(customerName, customerPhone, customerAddress, itemList);
        item.calculateTotalAmount();
        orderList.add(item);
    };

    /**
     * Prints the menu by iterating through the order list.
     */
    static void printMenu() {
        // Prompt the user to enter the order code
        System.out.println("Enter the order code to search: ");
        int orderCode = sc.nextInt();
        final int n = orderList.size();
        // Print the order information
        System.out.println("Order information: ");
        // Search The following item
        Order[] tempArr = orderList.toArray(new Order[n]);
        if(orderCode>n||orderCode<=0){
            System.out.println("Order not found");
            return;
        }
        tempArr[orderCode-1].setStatus(true);
        orderList = new LinkedList<>(Arrays.asList(tempArr));
    }

    /**
     * Prints the menu in sorted order.
     */
    static void printSortedMenu() {
        // Get the size of the order list
        final int n = orderList.size();
        // Print the size of the order list
        System.out.println(n);
        // Convert the order list to an array of Orders
        Order[] tempArr = orderList.toArray(new Order[n]);
        // Sort the array of Orders based on the total amount in descending order
        Arrays.sort(tempArr, (o1, o2) -> Double.compare(o1.getTotalAmount(), o2.getTotalAmount()));
        // Print each order in the sorted array
        for (Order order : tempArr) {
            System.out.println(order);
        }
    }

    /**
     * Prompts the user to enter an order code and searches for the corresponding
     * order
     * information in the orderList queue.
     */
    static void searchMenu() {
        // Prompt the user to enter the order code
        System.out.println("Enter the order code to search: ");
        int orderCode = sc.nextInt();

        // Print the order information
        System.out.println("Order information: ");
        final int n = orderList.size();
        // Create a temporary queue to store the orders
        Order[] tempArr = orderList.toArray(new Order[n]);

        // Check if the order code is greater than the number of orders in the list
        if (orderCode > n||orderCode<=0) {
            System.out.println("No order found");
            return;
        }
        // Print the desired order
        System.out.println(tempArr[orderCode-1]);
    }
    static void printProducts(){
        System.out.println("Enter the order code to search: ");
        int orderCode = sc.nextInt();

        // Print the order information
        System.out.println("Order information: ");
        final int n = orderList.size();
        // Create a temporary queue to store the orders
        Order[] tempArr = orderList.toArray(new Order[n]);


        // Check if the order code is greater than the number of orders in the list
        if (orderCode > n||orderCode<=0) {
            System.out.println("No order found");
            return;
        }

        // Remove the orders from the temporary queue until the desired order is reached

        // Print the desired order
        final Order item = tempArr[orderCode-1];
        final int itemSize = item.getItemList().size();
        for(int i=0;i<itemSize;i++)
        System.out.println(item.getItemList().get(i));
    }
    static void searchProducts(){
        System.out.println("Enter id");
        final int n = orderList.size();
        int id = sc.nextInt();
        Order[] tempArr = orderList.toArray(new Order[n]);
        Order[] result = new Order[n];
        int resultLength = 0;
        for(int i=0;i<n;i++){
            Product item = tempArr[i].getItemList().get(i).getItem();
            if(item.getPrd_id() == id) {
                result[resultLength++] = tempArr[i];
            }
        }
        for(int i=0;i<resultLength;i++){
            System.out.println(result[i]);
        }

    }
    static void ProcessedOrder (){
        // Prompt the user to enter the order code

        // Print the order information
        System.out.println("Order information: ");
        final int n = orderList.size();
        // Create a temporary queue to store the orders
        Order[] tempArr = orderList.toArray(new Order[n]);

        // Check if the order code is greater than the number of orders in the list
        for(int i=0;i<n;i++){
            if(tempArr[i].isStatus())System.out.println(tempArr[i]);
        }
    }
    static void SearchProcessedOrder(){
        // Prompt the user to enter the order code
        System.out.println("Enter the order code to search: ");
        int orderCode = sc.nextInt();

        // Print the order information
        System.out.println("Order information: ");
        final int n = orderList.size();
        // Create a temporary queue to store the orders
        Order[] tempArr = orderList.toArray(new Order[n]);

        // Check if the order code is greater than the number of orders in the list
        if (orderCode > n||orderCode<=0) {
            System.out.println("No order found");
            return;
        }
        // Print the desired order
        final Order item = tempArr[orderCode-1];
        if(item.isStatus())System.out.println("Don da duoc duyet");
        else System.out.println("Don chua duoc duyet");
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Nhap lua chon: ");
            System.out.println("1. Tao menu");
            System.out.println("2. Duyet don hang");
            System.out.println("3. Hien thi don hang theo gia tang dan");
            System.out.println("4. Tim kiem don hang");
            System.out.println("5. Hien thi danh sach san pham");
            System.out.println("6. Tim kiem san pham");
            System.out.println("7. Hien thi danh sach da duyet");
            System.out.println("8. Kiem tra don hang da duyet");    
            System.out.println("0. Thoat");
            final short choice = sc.nextShort();
            switch (choice) {
                case 1 -> createMenu();
                case 2 -> printMenu();
                case 3 -> printSortedMenu();
                case 4 -> searchMenu();
                case 5 -> printProducts();
                case 6 -> searchProducts();
                case 7 -> ProcessedOrder();
                case 8 -> SearchProcessedOrder();
                default -> {
                    return;
                }
            }

        }

    }
}
