/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lokey.onlineshopping;

import java.util.ArrayList;
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
    static void createMenu(){
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
        for(int i=0;i<n;i++){
            System.out.println("Nhap ten san pham: ");
            sc.nextLine();
            String prd_name = sc.nextLine();
            System.out.println("Nhap gia san pham: ");
            double  prd_price = sc.nextDouble();
            Product item = new Product(prd_name, prd_price );
            System.out.println("Nhap so luong/ khoi luong san pham: ");
            int quantity = sc.nextInt();
            itemList.add(new OrderItem(item, quantity));
        }
        Order item = new Order(customerName, customerPhone, customerAddress, itemList);
        item.calculateTotalAmout();
        orderList.add(item);
    };
    static void printMenu(){
        final Queue<Order> temp = new LinkedList<>(orderList);
        while(temp.peek()!=null){
            final Order head = temp.remove();
            head.setStatus(true);
            System.out.println(head);
        }
    };
    static void printSortedMenu(){
        final int n = orderList.size();
        System.out.println(n);
        Order[] tempArr = orderList.toArray(Order[]::new);
        //sort array by swap sort
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(tempArr[i].getTotalAmount()<tempArr[j].getTotalAmount()){
                    //swap i and j
                    Order tempItem = tempArr[i];
                    tempArr[i] = tempArr[j];
                    tempArr[j] = tempItem;
                }
            }
        }
        //print list
        for(int i=0;i<n;i++){
            System.out.println(tempArr[i]);
        }
        
    };
    public static <T> T get(Queue<T> queue, int index) {
    if (queue == null) {
        return null;
    }
    int size = queue.size();
    if (index < 0 || size < index + 1) {
        return null;
    }
    T element = null;
    for (int i = 0; i < size; i++) {
        T current = queue.remove();
        if (i == index) {
            element = current;
        }
        queue.add(current);
    }
    return element;
}

    static void searchMenu(){
        System.out.println("Nhap ma don hang can tim: ");
        int n = sc.nextInt();
        System.out.println("Thong tin don hang: ");
        Queue<Order> temp = orderList;
        if(n>orderList.size()) {
            System.out.println("There's nothing");
            return;
        }
        for(int i=0;i<n-1;i++){
            temp.remove();
        }
        System.out.println(temp.remove());
        
    }

    public static void main(String[] args) {
        while(true){
            System.out.println("Nhap lua chon: ");
            System.out.println("1. Tao menu");
            System.out.println("2. Duyet don hang");
            System.out.println("3. Hien thi don hang theo gia tang dan");
            System.out.println("4. Tim kiem don hang theo ma");
            System.out.println("0. Thoat");
            final short choice = sc.nextShort();
            switch(choice){
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
