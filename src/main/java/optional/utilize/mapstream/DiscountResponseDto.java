package optional.utilize.mapstream;

import java.util.Map;

public class DiscountResponseDto {
    private final Map<String, Integer> discountNameAndAmount;

    public DiscountResponseDto(Map<String, Integer> discountNameAndAmount) {
        this.discountNameAndAmount = discountNameAndAmount;
    }

    @Override
    public String toString() {
        return "DiscountResponseDto{" +
                "discountNameAndAmount=" + discountNameAndAmount +
                '}';
    }
}
