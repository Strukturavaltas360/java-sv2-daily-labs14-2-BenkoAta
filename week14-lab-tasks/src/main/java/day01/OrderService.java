package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    public List<Order> findOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> order.getOrderDate().isAfter(from) && order.getOrderDate().isBefore(to))
                .collect(Collectors.toList());
    }

    public boolean matchAnyOrderWithLessProductThan(int products) {
        return orders.stream()
                .anyMatch(order -> order.getProducts().size() < products);
    }

    public Order findOrderWithMostProducts() {
        return orders.stream()
                .sorted(Comparator.comparing(order -> order.getProducts().size(), Comparator.reverseOrder()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Empty list!"));
    }

    public List<Order> findOrdersWithProductByCategory(String category) {
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

    public List<Product> findOrderedProductsWithPriceGreaterThan(int minPrice) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getPrice() > minPrice)
                .toList();
    }
}
