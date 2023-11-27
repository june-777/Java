package optional.create;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Menu {
    STEAK("스테이크"),
    PASTA("파스타"),
    COLA("콜라");

    private static final Map<String, Menu> cachedMenu = new HashMap<>();
    private final String name;

    static {
        for (Menu menu : values()) {
            cachedMenu.put(menu.name, menu);
        }
    }

    Menu(String name) {
        this.name = name;
    }

    // 이름에 대한 메뉴가 없을 수도 있음
    public static Optional<Menu> findVer1(String name) {
        if(cachedMenu.containsKey(name)) {
            return Optional.of(cachedMenu.get(name));
        }
        return Optional.empty();
    }

    public static Optional<Menu> findVer2(String name) {
        return Optional.ofNullable(cachedMenu.get(name));
    }

    // 메뉴가 없을 때 별도의 비즈니스 로직을 수행해야 하는 경우 -> Ver1, Ver2
    // 그 외의 경우 -> Ver3
    public static Menu findVer3(String name) {
        return Optional.ofNullable(cachedMenu.get(name))
                .orElseThrow(IllegalArgumentException::new);
    }

    // Wrong Case1
    // null일수도 있을 땐 Optional.ofNullable 을 사용할 것
    // Optional.of 사용 시 NPE 발생
    // ref: 이벡티브 자바 아이템 55 - p.327
    public static Optional<Menu> wrongCase1(String name) {
        return Optional.of(cachedMenu.get(name));
    }

    // Wrong Case2
    // Optional을 반환하는 메서드에서는 절대 null을 반환하지 말 것
    // ref: 이펙티브 자바 아이템 55 - p.327
    public static Optional<Menu> wrongCase2(String name) {
        if(cachedMenu.containsKey(name)) {
            return Optional.of(cachedMenu.get(name));
        }
        return null;
    }
}
