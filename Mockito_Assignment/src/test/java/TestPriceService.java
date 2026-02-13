import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TestPriceService{

    @Test
    public void testDiscountForMob() {
        DiscountRepository repo =mock(DiscountRepository.class);
        PriceService service =new PriceService(repo);
        when(repo.getDiscountPercentage("MOB")).thenReturn(10.0);

        double finalPrice =service.calculateFinalPrice(1000,"MOB");
        assertEquals(900.0,finalPrice);
    }

    @Test
    public void testDiscountForLap() {
        DiscountRepository repo=mock(DiscountRepository.class);
        PriceService service= new PriceService(repo);
        when(repo.getDiscountPercentage("LAP")).thenReturn(20.0);

        double finalPrice= service.calculateFinalPrice(2000, "LAP");
        assertEquals(1600.0,finalPrice);
    }
}
