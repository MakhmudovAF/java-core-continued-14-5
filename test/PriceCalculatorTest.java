import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PriceCalculatorTest {
    private final PriceCalculator priceCalculator = new PriceCalculator();

    // Тесты для велосипеда (BIKE) - 3 теста
    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 0)
        );
        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs21Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 21)
        );
        Assertions.assertEquals("Bike can not go for more than 20 km", ex.getMessage());
    }

    @Test
    public void shouldReturn200ForBikeAndDistanceIs20Km() {
        int price = priceCalculator.calculatePrice(TransportType.BIKE, 20);
        Assertions.assertEquals(200, price); // 20 км * 10 = 200
    }

    // Тесты для автомобиля (CAR) - 3 теста
    @Test
    public void shouldThrowExceptionWhenCarAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 0)
        );
        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenCarAndDistanceIs1001Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 1001)
        );
        Assertions.assertEquals("Car can not go for more than 1000 km", ex.getMessage());
    }

    @Test
    public void shouldReturn7000ForCarAndDistanceIs1000Km() {
        int price = priceCalculator.calculatePrice(TransportType.CAR, 1000);
        Assertions.assertEquals(7000, price); // 1000 км * 7 = 7000
    }

    // Тесты для фуры (TRUCK) - 2 теста
    @Test
    public void shouldThrowExceptionWhenTruckAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.TRUCK, 0)
        );
        Assertions.assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        int price = priceCalculator.calculatePrice(TransportType.TRUCK, 1000);
        Assertions.assertEquals(5000, price); // 1000 км * 5 = 5000
    }

    // Тест для квадрокоптера (DRONE) - 1 тест
    @Test
    public void shouldThrowExceptionWhenDroneAndDistanceIs10Km() {
        UnsupportedOperationException ex = Assertions.assertThrows(
                UnsupportedOperationException.class,
                generateExecutable(TransportType.DRONE, 10)
        );
        Assertions.assertEquals("transport type 'DRONE' is not handled correctly", ex.getMessage());
    }

    private Executable generateExecutable(TransportType type, int distance) {
        return () -> priceCalculator.calculatePrice(type, distance);
    }
}