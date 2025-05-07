package com.bikash.question8;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class RunOrder {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(4,"shipped", BigDecimal.valueOf(50.49)),
                new Order(5,"cancelled", BigDecimal.valueOf(100.49)),
                new Order(7,"shipped", BigDecimal.valueOf(70.49)),
                new Order(6,"created", BigDecimal.valueOf(60.49)),
                new Order(8,"shipped", BigDecimal.valueOf(80.49)),
                new Order(1,"shipped", BigDecimal.valueOf(190.49)),
                new Order(2,"created", BigDecimal.valueOf(110.49)),
                new Order(3,"shipped", BigDecimal.valueOf(130.49)),
                new Order(9,"cancelled", BigDecimal.valueOf(140.49))
        );
        System.out.println("All orders are above 50 ? : "+matchPrice(orders, BigDecimal.valueOf(50)));
        System.out.println("Any Order got Shipped : "+isOrderShipped(orders));
        System.out.println("Any Cancelled Order : "+checkCancelledOrder(orders));
        getOrder(orders,3);
    }

    // Check if all orders are above a certain amount.
    public static boolean matchPrice(List<Order> orders, BigDecimal val){
        return orders.stream()
                .allMatch(order -> order.getAmount().compareTo(val) > 0);
    }


    // check if any order has a status of "shipped"
    public static boolean isOrderShipped(List<Order> orders){
        return orders.stream()
                .anyMatch(order -> order.getStatus().equalsIgnoreCase("shipped"));
    }

    //check if no order has a status of "cancelled"
    public static boolean checkCancelledOrder(List<Order> orders){
        return orders.stream()
                .noneMatch(order -> order.getStatus().equalsIgnoreCase("cancelled"));
    }

//    retrieve an order with a specific “orderId” and print it
    public static void getOrder(List<Order> orders, Integer orderId){
        Order result = orders.stream()
                .filter(order -> Objects.equals(order.getOrderId(), orderId))
                .findAny()
                .orElse(null);
        System.out.println(result);
    }
    // Since this is a sequential stream, both findFirst() and findAny() return the first element ("Alice"), {List.of("Alice", "Bob", "Charlie", "David", "Emma")}
    // but findAny() isn't guaranteed to do so in a parallel stream.
}
