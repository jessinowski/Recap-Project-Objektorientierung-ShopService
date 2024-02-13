import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();

        shopService.getProductRepo().addProduct(new Product("2", "Banane"));
        shopService.getProductRepo().addProduct(new Product("3", "Birne"));
        List<Product> products = shopService.getProductRepo().getProducts();
        List<String> productIds = products.stream()
                .map(product -> product.id())
                .toList();
        try {
            shopService.addOrder(productIds);
        } catch (NoOrderFoundException e) {
            e.getMessage();
        }

    }
}
