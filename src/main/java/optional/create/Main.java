package optional.create;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Menu> findMenu1 = Menu.findVer1("ㅇㅇ");
        System.out.println(findMenu1);

        Optional<Menu> findMenu2 = Menu.findVer2("oo");
        System.out.println(findMenu2);

        orElseEx();
        mapEx_notUseMap();
    }

    // orElse(T t)
    // Optional 값이 없는 경우 -> 기본값을 정해둘 수 있다.
    static void orElseEx() {
        Optional<Menu> menuOptional = Menu.findVer2("oo");
        Menu findMenu = menuOptional.orElse(Menu.COLA);
        System.out.println(findMenu);
    }

    // orElseGet(Supplier supplier)
    // Optional 값이 없는 경우 -> 예외를 던질 수 있다.
    static void orElseThrowEx() {
        Optional<Menu> menuOptional = Menu.findVer2("oo");
        menuOptional.orElseThrow(IllegalArgumentException::new);
    }

    static void mapEx_notUseMap() {
        Optional<Menu> menuOptional = Menu.findVer2("스테이이크");
        String findMenu = null;
        if(menuOptional.isPresent()) {
            findMenu = menuOptional.get().name();
        } else {
            findMenu = "없음";
        }
        System.out.println(findMenu);
    }

    static void mapEx_useMap() {
        Optional<Menu> menuOptional = Menu.findVer2("스테이이크");
        String findMenu = menuOptional.map(menu -> menu.name())
                .orElse("없음");
        System.out.println(findMenu);
    }
}
