package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long dbOfOrders(String category) {
        return orders.stream().flatMap(o -> o.getProducts().stream()).filter(o -> o.getCategory().equals(category)).count();
    }

    public long ordersBetweenDate(LocalDate start, LocalDate end) {
        return orders.stream().filter(o -> o.getOrderDate().isAfter(start) && o.getOrderDate().isBefore(end))
                .flatMap(o -> o.getProducts().stream()).count();
    }

    public boolean isExistOrders(int minDb) {
        return orders.stream().anyMatch(o -> o.getProducts().size() < minDb);
    }

    public Optional<Order> maxDbOrder() {
        Optional op = orders.stream().max(Comparator.comparing(o -> o.getProducts().size()));
        return op;
    }

    public List<Order> thereIsProduct(String category) {
        return orders.stream().flatMap(o -> o.getProducts().stream()).filter(o -> o.getCategory().equals(category))
                .collect(Collectors.toList());
    }



}
