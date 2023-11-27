package optional.utilize.orelse_vs_orelseget;

import java.util.Optional;
import java.util.function.Supplier;

public class OrElse_OrElseGet {
    public static void main(String[] args) {
        String username = null;
        String name = Optional.ofNullable(username).orElse(getDefaultName());

//        Supplier<String> supplier = () -> getDefaultName();
        System.out.println("ofNullable Called");
        String name2 = Optional.ofNullable(username).orElseGet(() -> getDefaultName());

        System.out.println("name = " + name);
        System.out.println("name2 = " + name2);
    }

    static String getDefaultName() {
        return "no Name";
    }
}
