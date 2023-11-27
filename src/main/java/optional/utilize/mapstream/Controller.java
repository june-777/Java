package optional.utilize.mapstream;

import java.util.Optional;

public class Controller {

    private final DiscountService discountService = new DiscountService();

    public DiscountResponseDto processVer1() {
        int purchaseAmount = 10_000;
        Optional<DiscountInformation> discount = discountService.discount(purchaseAmount);

        if(discount.isPresent()) {
            return DiscountResponseMapper.of(discount.get().getDiscountNameAndAmount());
        }
        return DiscountResponseMapper.ofEmpty();
    }

    public DiscountResponseDto processVer2() {
        int purchaseAmount = 9_999;
        Optional<DiscountInformation> discountInfo = discountService.discount(purchaseAmount);

        return discountInfo.map(
                    info -> DiscountResponseMapper.of(info.getDiscountNameAndAmount()))
                .orElseGet(DiscountResponseMapper::ofEmpty);
    }
}
