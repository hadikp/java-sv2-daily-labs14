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

    public List<Order> findOrdersbyStatus(String status) {
        //return orders.stream().flatMap(o -> o.getProducts().stream()).filter(o -> o.getCategory().equals(category)).count();
        return orders.stream().filter(o -> o.getStatus().equals(status)).collect(Collectors.toList());
    }

    public long countOrderByStatus(String status) { //rendelések darabszáma paraméterként kapott státus alapján
        return orders.stream().filter(o -> o.getStatus().equals(status)).count();
    }

    public long ordersBetweenDates(LocalDate start, LocalDate end) { //Add vissza azokat a rendeléseket amik két dátum között vannak
        return orders.stream().filter(o -> o.getOrderDate().isAfter(start) && o.getOrderDate().isBefore(end))
                .flatMap(o -> o.getProducts().stream()).count();
    }

    public boolean isExistOrders(int minDb) { //Van e olyan rendelés, amiben kevesebb mint paraméternyi termék található
        return orders.stream().anyMatch(o -> o.getProducts().size() < minDb);
        //return !orders.stream().filter(o -> o.getProducts().size() > minDb).collect(Collectors.toList()).isEmpty();
    }

    public Optional<Order> maxDbOrder() { //Keresd meg azt a rendelést amiben a legtöbb termék található
        Optional op = orders.stream().max(Comparator.comparing(o -> o.getProducts().size())); //.orElseThrow( ()->throw new Kivétel Order-hez
        return op;
    }

   public List<Order> thereIsProduct(String category) { //Gyújtsük ki azokat a rendeléseket amiben van adott kategóriájú termék
        return orders.stream().filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

    public List<Product> findProductOverPrice(int amount) { //azon termékek amik bizonyos ár fölött vannak
        return orders.stream().flatMap(o -> o.getProducts().stream()).filter(p -> p.getPrice() > amount).distinct().toList();
    }



}
