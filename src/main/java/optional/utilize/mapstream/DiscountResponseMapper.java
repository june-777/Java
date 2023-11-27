package optional.utilize.mapstream;

import java.util.HashMap;
import java.util.Map;

public class DiscountResponseMapper {

    public static DiscountResponseDto of(Map<String, Integer> discountInfo) {
        return new DiscountResponseDto(discountInfo);
    }

    public static DiscountResponseDto ofEmpty() {
        return new DiscountResponseDto(new HashMap<>());
    }
}
