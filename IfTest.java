import java.util.Arrays;

public interface TestIf {
    static void main(String[] args) {
        new If(args.length > 0) {
            void then() {
                System.out.println("Args are:");
                Arrays.stream(args).forEach(System.out::println);
            }
            void otherwise() {
                System.out.println("No args provided.");
            }
        };
    }
}
