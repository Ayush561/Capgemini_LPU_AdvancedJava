public class PriceService {

    private DiscountRepository repo;

    public PriceService(DiscountRepository repo) {
        this.repo = repo;
    }

    public double calculateFinalPrice(double price, String productCode) {
        double discount = repo.getDiscountPercentage(productCode);
        return price - (price * discount / 100);
    }
}
