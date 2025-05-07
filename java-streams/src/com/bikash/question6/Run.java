package com.bikash.question6;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Run {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(3, "Television", "Electronics", BigDecimal.valueOf(199.09)),
                new Product(1, "Refrigerator", "Electronics", BigDecimal.valueOf(189.09)),
                new Product(2, "Shirt", "Clothing", BigDecimal.valueOf(13.01)),
                new Product(5, "Table", "Furniture", BigDecimal.valueOf(100)),
                new Product(4, "Speaker", "Electronics", BigDecimal.valueOf(159.99)),
                new Product(6, "Trouser", "Clothing", BigDecimal.valueOf(15.09)),
                new Product(9, "Tie", "Clothing", BigDecimal.valueOf(6)),
                new Product(7, "Chair", "Furniture", BigDecimal.valueOf(51.99)),
                new Product(8, "Cellphone", "Electronics", BigDecimal.valueOf(1199.99))
        );

//        sortByCategoryThenPrice(products);
        sortViaCustomComparator(products);
    }

//    Sort the list of products first by category and then by price in descending order
    public static void sortByCategoryThenPrice(List<Product> products){
        List<Product> result = products.stream()
                .sorted(Comparator.comparing(Product::getCategory)
                        .thenComparing(Comparator.comparing(Product::getPrice).reversed()))
                .toList();
        System.out.println(result);

    }

    // Implement a custom comparator for case-insensitive string sorting for the product names.
    public static void sortViaCustomComparator(List<Product> products){
        List<Product> result = products.stream()
                .sorted(getComparator())
                .toList();
        System.out.println(result);
    }

    public static Comparator<Product> getComparator(){
        return  Comparator.comparing(product -> product.getName().toLowerCase());
    }
}
