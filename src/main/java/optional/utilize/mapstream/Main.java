package optional.utilize.mapstream;

/**
 * Sample Code Description
 *
 * Dependency: Controller -> DiscountService
 * 1. DiscountInformation은 고객이 받은 할인 혜택 정보를 의미한다.
 * 2. 비즈니스 요구사항에 의해, DiscountInformation은 없을 수도 있다.
 * 3. DiscountService는 Optional<DiscountInformation> 반환한다.
 * 4. Controller에서 Optional.map + Optional.orElseGet을 활용
 */

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        DiscountResponseDto discountResponseDto = controller.processVer1();
        System.out.println(discountResponseDto);
    }
}
