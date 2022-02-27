import java.util.Optional;
import java.util.OptionalInt;

public class StreamOptional {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();

        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x-> System.out.printf("result3 = %d%n", x));

        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();

        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());

        Optional<String> opt = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.empty();
        System.out.println("opt.equals(opt2) ? " + opt.equals(opt2));

    }
}
