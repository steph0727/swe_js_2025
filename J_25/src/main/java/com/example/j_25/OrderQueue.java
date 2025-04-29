package com.example.j_25;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private static final Queue<Order> orders = new LinkedList<>();

    public static void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order added: " + order);
    }

    public static Order getNextOrder() {
        return orders.poll();
    }

    public static boolean isEmpty() {
        return orders.isEmpty();
    }

    public static void printQueue() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}