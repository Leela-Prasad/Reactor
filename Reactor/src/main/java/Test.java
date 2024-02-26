import com.github.javafaker.Faker;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        Faker instance = Faker.instance();

        IntStream.range(1, 11)
                        .forEach(i -> System.out.println(instance.name().fullName()));
    }
}
