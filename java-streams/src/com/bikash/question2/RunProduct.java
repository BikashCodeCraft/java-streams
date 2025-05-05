package com.bikash.question2;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RunProduct {

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
        getProductWithSpecificValue(products, 100.00);
        getProductWithSpecificCategory(products, List.of("ELECTRONICS","Clothing"));
        getProductWithFilterAndGrouping(products, List.of("ELECTRONICS","Clothing"));
        getTotalPriceForEachCategory(products);
        printSortedProductWithInCategoryByPriceDesc(products);
    }

    //    Only include products with a price greater than a specific value.
    public static void getProductWithSpecificValue(List<Product> products, double price) {
        List<Product> productsOverPrice = products.stream()
                .filter(product -> product.getPrice().doubleValue() > price)
                .toList();
        System.out.println(productsOverPrice);
    }
    // Only include products with specific categories.
    public static void getProductWithSpecificCategory(List<Product> products, List<String> categories) {
        List<Product> productsOverPrice = products.stream()
                .filter(product -> categories.stream().anyMatch(category->product.getCategory().equalsIgnoreCase(category)))
                .toList();
        System.out.println(productsOverPrice);
    }

    //Group the filtered products by category using “Collectors.groupingBy()”.
    public static void getProductWithFilterAndGrouping(List<Product> products, List<String> categories) {
        Map<String, List<Product>> result = products.stream()
                .filter(product -> categories.stream().anyMatch(category -> product.getCategory().equalsIgnoreCase(category)))
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(result);
    }

    //Aggregate the results within each category by computing the total price of all products in that category
    public static void getTotalPriceForEachCategory(List<Product> products){
        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(product -> product.getPrice().doubleValue())));
        System.out.println(result);

    }

    //Sort the products within each category by price in descending order
    public static void printSortedProductWithInCategoryByPriceDesc(List<Product> products){
        Map<String, List<Product>> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.collectingAndThen(Collectors.toList(), productList -> productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList()))
                );
        System.out.println(result);
    }

}
