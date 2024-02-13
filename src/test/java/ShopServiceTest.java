import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() throws NoOrderFoundException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        Order expected = new Order("-1", List.of(java.util.Optional.of(new Product("1", "Apfel"))), null);
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectNull() throws NoOrderFoundException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");

        //THEN
        assertThrows(NoOrderFoundException.class,() ->{shopService.addOrder(productsIds);});
    }

    @Test
    void sortByOrderStatus() {
        ShopService shopService = new ShopService();
        List<Order> orders;

    }
}
