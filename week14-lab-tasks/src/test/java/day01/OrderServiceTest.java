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
        o1.addProduct(p4);

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
    void findOrdersbyStatus() {
        List<Order> result = orderService.findOrdersbyStatus("pending");
        assertEquals(3, result.size());
        assertEquals(4, result.get(0).getProducts().size());
    }

    @Test
    void countOrdersbyStatus() {
        long result = orderService.countOrderByStatus("pending");
        assertEquals(3, result);
    }

    @Test
    void testOrdersBetweenDates() {
        assertEquals(10, orderService.ordersBetweenDates(LocalDate.of(2021, 06, 01), LocalDate.of(2021, 06, 8)));
        assertEquals(16, orderService.ordersBetweenDates(LocalDate.of(2021, 05, 31), LocalDate.of(2021, 06, 8)));
        assertEquals(0, orderService.ordersBetweenDates(LocalDate.of(2021, 06, 8), LocalDate.of(2021, 06, 30)));
    }

    @Test
    void testIsExistOrders() {
        assertTrue(orderService.isExistOrders(4));
        assertFalse(orderService.isExistOrders(3));
    }

    @Test
    void testMaxDbOrder() {
        System.out.println(orderService.maxDbOrder());
    }

    @Test
    void testThereIsProduct() {
       System.out.println(orderService.thereIsProduct("Book"));
    }

    @Test
    void testFindProductOverPrice() {
        System.out.println(orderService.findProductOverPrice(400));
    }

}