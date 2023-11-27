package optional.utilize.orelse_vs_orelseget;

import java.util.Optional;
import java.util.function.Supplier;

public class OrElse_OrElseGet {
    public static void main(String[] args) {
        String username = null;
        // orElse: Optional에 값이 있든 없든, 호출될 가능성이 있다.
        String defaultName = getDefaultName();
        String name = Optional.ofNullable(username).orElse(defaultName);

        // orElseGet: Optional에 값이 없는 경우만 호출된다.
        Supplier<String> supplier = () -> getDefaultName();
        String name2 = Optional.ofNullable(username).orElseGet(supplier);
    }

    static String getDefaultName() {
        return "no Name";
    }
}
