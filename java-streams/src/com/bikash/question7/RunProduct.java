package com.bikash.question7;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RunProduct {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(3, "Television", BigDecimal.valueOf(199.09)),
                new Product(1, "Refrigerator", BigDecimal.valueOf(189.09)),
                new Product(2, "Shirt", BigDecimal.valueOf(13.01)),
                new Product(5, "Table", BigDecimal.valueOf(100)),
                new Product(4, "Speaker", BigDecimal.valueOf(159.99)),
                new Product(6, "Trouser", BigDecimal.valueOf(15.09)),
                new Product(9, "Tie", BigDecimal.valueOf(6)),
                new Product(7, "Chair", BigDecimal.valueOf(51.99)),
                new Product(8, "Cellphone", BigDecimal.valueOf(1199.99))
        );

        usePeek(products);
    }

//    Perform a sequence of operations on the stream, such as filtering products with prices over 100 and then transforming
//    them into a list of uppercase names.
//    Print the intermediate results at each stage using “peek()”.

    public static void usePeek(List<Product> products){
        List<String> result = products.stream()
                .peek(product -> {System.out.println("Peeked after stream : "+product);})
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .peek(product -> {System.out.println("Peeked after sorting : "+product);})
                .filter(product -> product.getPrice().doubleValue() > 100)
                .peek(product -> {System.out.println("Peeked after filter : "+product);})
                .map(product -> product.getName().toUpperCase())
                .peek(product -> {System.out.println("Peeked after map : "+product);})
                .toList();

//        List<Product> productList = products.stream()
//                .peek(product -> {System.out.println("Peeked after stream : "+product);})
//                .filter(product -> product.getPrice().doubleValue() > 100)
//                .peek(product -> {System.out.println("Peeked after filter : "+product);})
//                .map(product -> new Product(product.getId(), product.getName().toUpperCase(), product.getPrice()))
//                .peek(product -> {System.out.println("Peeked after map : "+product);})
//                .toList();
    }

}
