package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 06, 07));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 06, 07));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);
        o4.addProduct(p1);

        Order o5 = new Order("pending", LocalDate.of(2021, 06, 07));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void findOrdersByStatusTest() {
        List<Order> actual = orderService.findOrdersByStatus("pending");
        assertEquals(3, actual.size());
        assertEquals("pending", actual.get(0).getStatus());
        
    }

    @Test
    void countOrdersByStatus() {
        long actual = orderService.countOrdersByStatus("pending");
        assertEquals(3, actual);
    }

    @Test
    void findOrdersBetweenDatesTest() {
        List<Order> actual = orderService.findOrdersBetweenDates(LocalDate.of(2021, 6, 6), LocalDate.of(2021,6,8));
        assertEquals("2021-06-07", actual.get(1).getOrderDate().toString());
    }

    @Test
    void findOrdersBetweenDatesNotFoundTest() {
        List<Order> actual = orderService.findOrdersBetweenDates(LocalDate.of(2021, 6, 7), LocalDate.of(2021,6,8));
        assertEquals(0, actual.size());
        actual = orderService.findOrdersBetweenDates(LocalDate.of(2021, 6, 6), LocalDate.of(2021,6,7));
        assertEquals(0, actual.size());
    }

    @Test
    void matchAnyOrderWithLessProductThan() {
        assertTrue(orderService.matchAnyOrderWithLessProductThan(4));
        assertFalse(orderService.matchAnyOrderWithLessProductThan(3));
    }


    @Test
    void findOrderWithMostProductsTest() {
        Order actual = orderService.findOrderWithMostProducts();
        assertEquals(4, actual.getProducts().size());
    }

    @Test
    void findOrdersWithProductByCategory() {
        List<Order> actual = orderService.findOrdersWithProductByCategory("Book");
        assertEquals(3, actual.size());
        for (Order order: actual) {
            assertTrue(order.getProducts().get(2).getCategory().equals("Book"));
        }
    }

    @Test
    void findOrderedProductsWithPriceGreaterThan() {
        System.out.println(orderService.findOrderedProductsWithPriceGreaterThan(10));
    }
}