import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) throws NoOrderFoundException {
        List<Optional<Product>> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> productToOrder = productRepo.getProductById(productId);
            if (productToOrder.isEmpty()) {
                throw new NoOrderFoundException("Produkt mit der Id: " + productId + " konnte nicht bestellt werden!");
            }
            products.add(productToOrder);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products, null);

        return orderRepo.addOrder(newOrder);
    }

    public List<Order> sortByOrderStatus(OrderStatus orderStatus){
        List<Order> ordersByStatus = orderRepo.getOrders().stream()
                .filter(order -> order.orderStatus().equals(orderStatus))
                .toList();
        return ordersByStatus;
    }

    public Order updateOrder(String id, OrderStatus orderStatus){
        return orderRepo.getOrderById(id).withOrderStatus(orderStatus);
    }
}
