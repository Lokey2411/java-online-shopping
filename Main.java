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
        // Create a temporary queue and initialize it with the order list
        final Queue<Order> temp = new LinkedList<>(orderList);

        // Iterate through the temporary queue
        while (temp.peek() != null) {
            // Remove and store the head of the queue
            final Order head = temp.remove();

            // Set the status of the order to true
            head.setStatus(true);

            // Print the order
            System.out.println(head);
        }
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
        Order[] tempArr = orderList.toArray(Order[]::new);
        // Sort the array of Orders based on the total amount in descending order
        Arrays.sort(tempArr, (o1, o2) -> Double.compare(o2.getTotalAmount(), o1.getTotalAmount()));
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

        // Create a temporary queue to store the orders
        Queue<Order> temp = orderList;

        // Check if the order code is greater than the number of orders in the list
        if (orderCode > orderList.size()) {
            System.out.println("No order found");
            return;
        }

        // Remove the orders from the temporary queue until the desired order is reached
        for (int i = 0; i < orderCode - 1; i++) {
            temp.remove();
        }

        // Print the desired order
        System.out.println(temp.remove());
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Nhap lua chon: ");
            System.out.println("1. Tao menu");
            System.out.println("2. Duyet don hang");
            System.out.println("3. Hien thi don hang theo gia tang dan");
            System.out.println("4. Tim kiem don hang theo ma");
            System.out.println("0. Thoat");
            final short choice = sc.nextShort();
            switch (choice) {
                case 1 -> createMenu();
                case 2 -> printMenu();
                case 3 -> printSortedMenu();
                case 4 -> searchMenu();
                default -> {
                    return;
                }
            }

        }

    }
}
