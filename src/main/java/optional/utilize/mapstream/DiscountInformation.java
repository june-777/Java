package optional.utilize.mapstream;

import java.util.Map;

public class DiscountInformation {
    private final Map<String, Integer> discountNameAndAmount;

    public DiscountInformation(Map<String, Integer> discountNameAndAmount) {
        this.discountNameAndAmount = discountNameAndAmount;
    }

    public Map<String, Integer> getDiscountNameAndAmount() {
        return discountNameAndAmount;
    }
}
