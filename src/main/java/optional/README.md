## Optional

#### Create
```java
// 1. 빈 Optional 생성
Optional<T> result = Optional.empty();

// 2. Optional 생성
Optional<T> result = Optional.of(T something);

// 3. null일수도 있을 때 Optional 생성
Optional<T> result = Optional.ofNullable(T something);

// 4. null일 때 예외를 반환
Optional.ofNullable(T something)
        .orElseThrow(IllegalArgument::new);
```

<br>

#### Wrong Case
```java
// wrong case 1
// null일수도 있을 땐 Optional.ofNullable 을 사용할 것
// Optional.of 사용 시 NPE 발생
public static Optional<Menu> wrongCase1(String name) {
    return Optional.of(cachedMenu.get(name));
}

// wrong case 2
// Optional을 반환하는 메서드에서는 절대 null을 반환하지 말 것
public static Optional<Menu> wrongCase2(String name) {
    if(cachedMenu.containsKey(name)) {
        return Optional.of(cachedMenu.get(name));
    }
    return null;
}
```
> ref: 이펙티브 자바 - 아이템 55 - page 327

<br>

#### Utilize
1. `orElse(T t)`  
Optional의 값이 없을 때 기본 값을 설정하는 방법
    ```java
    String username = null;
    String name = Optional.ofNullable(username).orElse(getDefaultName());
    
    static String getDefaultName() {
        return "no Name";
    }
    // print: no Name
    ```
<br>

2. `orElseGet(Supplier< T > supplier)`  
Optional의 값이 없을 때 기본 값을 설정하는 방법  
값이 처음 필요할 때 Supplier를 사용한다
    ```java
    String username = null;
    String name = Optional.ofNullable(username).orElse(() -> getDefaultName());
        
    static String getDefaultName() {
        return "no Name";
    }
    // print: no Name
    ```
    ❗️`orElse` vs `orElseGet`
   - orElse: Optional의 값이 있든 없든 호출될 수 있다.
       ```java
       String username = null;
       String defaultName = getDefaultName();
       String name = Optional.ofNullable(username).orElse(defaultName);
    
       static String getDefaultName() {
           return "no Name";
       }
       ```
   - orElseGet: Optional의 값이 없을 때만 호출된다.
       ```java
       String username = null;
       Supplier<String> defaultName = () -> getDefaultName();
       String name = Optional.ofNullable(username).orElse(defaultName);
    
       static String getDefaultName() {
           return "no Name";
       }
       ```
     >   ref: https://cfdf.tistory.com/34

<br>

3. `map(Function f)`  
Optional 값을 map Function을 적용하여 변환하고 싶을 때 사용  
stream Map과 같은 맥락  
`if present ~` 를 `map ~ orElseGet`구문으로 활용할 수 있음
    ```java
    public DiscountResponseDto nonFunctionalStyle() {
        Optional<DiscountInformation> discount = discountService.discount(purchaseAmount);

        if(discount.isPresent()) {
            return DiscountResponseMapper.of(discount.get().getDiscountNameAndAmount());
        }
        return DiscountResponseMapper.ofEmpty();
    }
    ```
    ```java
    public DiscountResponseDto functionalStyle() {
        Optional<DiscountInformation> discountInfo = discountService.discount(purchaseAmount);

        return discountInfo.map(
                    info -> DiscountResponseMapper.of(info.getDiscountNameAndAmount()))
                .orElseGet(DiscountResponseMapper::ofEmpty);
    }
    ``` 

<br>

4. `orElseThrow()`  
null일 때 예외를 반환  
    ```java
    Optional.ofNullable(T something)
            .orElseThrow(IllegalArgument::new);
    ```
