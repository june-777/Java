package optional.utilize.mapstream;

import java.util.HashMap;
import java.util.Optional;

public class DiscountService {

    private static int MIN_APPLICABLE_PURCHASE_AMOUNT = 10000;

    public Optional<DiscountInformation> discount(int purchaseAmount) {
        if(purchaseAmount < MIN_APPLICABLE_PURCHASE_AMOUNT) {
            return Optional.empty();
        }
        HashMap<String, Integer> discountInfo = new HashMap<>();
        discountInfo.put("크리스마스 할인", 2000);
        discountInfo.put("평일 할인", 1000);
        DiscountInformation discountInformation = new DiscountInformation(discountInfo);
        return Optional.of(discountInformation);
    }
}
