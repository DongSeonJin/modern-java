package org.example;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class parallelStream {
    List<Apple> inventory = Arrays.asList(new Apple(10), new Apple(2), new Apple(30), new Apple(200));

    // 순차 처리 방식
    List<Apple> heavyApples1 = inventory.stream()
            .filter(apple -> apple.getWeight() > 10)
            .collect(toList());

    // 병렬 방식
    List<Apple> heavyApples2 = inventory.parallelStream()
            .filter((Apple a) -> a.getWeight() > 10)
            .collect(toList());


    public static class Apple {
        private final int weight;

        public int getWeight() {
            return weight;
        }

        public Apple() {
            this.weight = 0;
        }

        public Apple(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        parallelStream ps = new parallelStream();
        ps.heavyApples1.forEach(apple -> System.out.println(apple.getWeight()));
        ps.heavyApples2.forEach(apple -> System.out.println(apple.getWeight()));
    }
}




