import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        /**
         * Given the following input data.
         */
        List<Integer> numbers = IntStream.range(0, 1_000)
                .boxed()
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("One", "Two", "three", "four", "five", "six", "seven", "Eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "Fourteen", "fifteen", "sixteen", "Nineteen", "twenty");

        /**
         * Implement ONE method PER exercise given todos:
         */

        /**
         * For each
         */
        // 1: using "numbers" as input, print first ten numbers X
//        example(numbers);
        // 2: using "numbers" as input print first ten odd numbers X
        System.out.println("------ ex2 -------");
        exercise2(numbers);
        System.out.println();
        // 3: using "numbers" as input print first ten even numbers X
        System.out.println("------ ex3 -------");
        exercise3(numbers);
        System.out.println();
        // 4: implement 1, 2, 3 using one method X
        System.out.println("------ ex4 -------");
        exercise4(numbers, e->true);
        System.out.println();
        exercise4(numbers, num -> num %2 == 1);
        System.out.println();
        exercise4(numbers, num -> num %2 == 0);
        System.out.println();


        /**
         * Sums
         */
        // 5. using "numbers" as input print their sum X
        System.out.println("------ ex5 -------");
        exercise5(numbers);
        // 6. using "numbers" as input print the sum of the odd numbers X
        System.out.println("------ ex6 -------");
        exercise6(numbers);
        // 7. using "numbers" as input print the sum of the even numbers X
        System.out.println("------ ex7 -------");
        exercise7(numbers);
        // 8. using "numbers" as input print the sum of the even numbers which contain '7' X
        System.out.println("------ ex8 -------");
        exercise8(numbers);
        // 9. implement 5, 6, 7, 8 using one method X
        System.out.println("------ ex9 -------");
        exercise9(numbers, e ->true);
        exercise9(numbers, num -> num % 2 == 1);
        exercise9(numbers, num -> num % 2 == 0);
        exercise9(numbers, num -> num.toString().indexOf('7') > -1);

        /**
         * Mixed map/filter/reduce
         */
        // 10. using "numbers" calculate the sum of the double of even numbers X
        System.out.println("------ ex10 -------");
        exercise10(numbers);
        // 11. using "numbers" calculate the sum of the triple of odd numbers X
        System.out.println("------ ex11 -------");
        exercise11(numbers);
        // 12. using "numbers" calculate the sum of their half (1/2) X
        System.out.println("------ ex12 -------");
        exercise12(numbers);
        // 13 implement 10, 11, 12 using one method X
        System.out.println("------ ex13 -------");
        exercise13(numbers, num -> num * 2, num -> num % 2 == 0);
        exercise13(numbers, num -> num * 3, num -> num % 2 == 1);
        exercise13(numbers, num -> num / 2, e -> true);

        /**
         * Collectors
         */
        // 14. using "words" as input print a string with each UPPERCASED word separated by ', ' X
        System.out.println("------ ex14 -------");
        exercise14(words);
        System.out.println();
        // 15. using "words" as input create a List containing all words starting with a vowel X
        System.out.println("------ ex15 -------");
        List<String> list15 = exercise15(words);
        list15.forEach(System.out::println);
        // 16. using "words" as input create a List containing all words ending in 'teen' X
        System.out.println("------ ex16 -------");
        List<String> list16 = exercise16(words);
        list16.forEach(System.out::println);
        // 17. implement 11 and 12 using one method
        System.out.println("------ ex17 -------");
        exercise17(numbers, num -> num % 2 == 1, num -> num * 3);
        exercise17(numbers, e -> true, num -> num / 2);
        // 18. using words as input create a Set of words with an odd number of letters
        System.out.println("------ ex18 -------");
        Set<String> set18 = exercise18(words);
        set18.forEach(System.out::println);
        // 19. using words as input create a Set containing the number of letters in a word
        System.out.println("------ ex19 -------");
        Set<Integer> set19 = exercise19(words);
        set19.forEach(System.out::println);

        /**
         * Converting to java 8
         */
        // 20. convert the following code to java 8
        System.out.println("------------ Not Java 8 -------------");
        nonJava8Method(numbers);
        System.out.println("-------------- Java 8 -------------");
        java8Method(numbers);


        /**
         * Optional<T>
         */
        // 21. using "numbers" as input print the first odd number that can be divided by 121, if it does not exist print -1
        System.out.println("------ ex21 -------");
        exercise21(numbers);
    }

    /**
     *  For each exercises
     */
    private static void example(List<Integer> numbers) {
        numbers.stream()
                .limit(10)
                .forEach(System.out::print);
    }

    private static void exercise2(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num % 2 == 1)
                .limit(10)
                .map(num -> num + " ")
                .forEach(System.out::print);
    }

    private static void exercise3(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num %2 == 0)
                .limit(10)
                .map(num -> num + " ")
                .forEach(System.out::print);
    }

    private static void exercise4(List<Integer> numbers, Predicate<Integer> condition) {
        numbers.stream()
                .filter(condition)
                .limit(10)
                .map(num -> num + " ")
                .forEach(System.out::print);
    }

    /**
     * Sums exercises
     */
    private static void exercise5(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise6(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .filter(num -> num % 2 == 1)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise7(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .filter(num -> num % 2 == 0)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise8(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .filter(num -> num.toString().indexOf('7') > -1)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise9(List<Integer> numbers, Predicate<Integer> condition) {
        System.out.println(
                numbers.stream()
                    .filter(condition)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    /**
     *  map/filter/reduce exercises
    */

    private static void exercise10(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .filter(num -> num % 2 == 0)
                    .map(num -> num * 2)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise11(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .filter(num -> num % 2 == 1)
                    .map(num -> num * 3)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise12(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .map(num -> num / 2)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    private static void exercise13(List<Integer> numbers,
                                   Function<Integer,Integer> mapper, Predicate<Integer> condition) {
        System.out.println(
                numbers.stream()
                    .filter(condition)
                    .map(mapper)
                    .reduce(0, (result, num) -> result + num)
        );
    }

    /**
     * Collectors
     */

    private static void exercise14(List<String> words) {
        words.stream()
                .map(word -> word.toUpperCase() + ", ")
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }

    private static List<String> exercise15(List<String> words) {
        return words.stream()
                .filter(word -> word.toLowerCase().matches("[a,e,i,o,u].*"))
                .collect(Collectors.toList());

    }

    private static List<String> exercise16(List<String> words) {
        return words.stream()
                .filter(word -> word.toLowerCase().endsWith("teen"))
                .collect(Collectors.toList());
    }

    private static void exercise17(List<Integer> numbers,
                                   Predicate<Integer> condition, Function<Integer, Integer> mapper) {
        System.out.println(
                numbers.stream()
                        .filter(condition)
                        .map(mapper)
                        .collect(Collectors.toList())
                        .stream()
                        .reduce(0, (result, num) -> result + num)
        );
    }

    private static Set<String> exercise18(List<String> words) {
        return words.stream()
                .filter(word -> word.length() % 2 == 1)
                .collect(Collectors.toSet());
    }

    private static Set<Integer> exercise19(List<String> words) {
        return words.stream()
                .map(word -> word.length())
                .collect(Collectors.toSet());
    }

    /**
     * Non Java 8 -> Java 8
     */
    private static void java8Method(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                        .filter(num -> num % 2 == 0)
                        .limit(6)
                        .map(num -> num + 5)
                        .map(num -> num * 7)
                        .map(num -> num % 20 == 3 ? num / 20 : num)
                        .reduce(0, (result, num) -> result + num / 10)
        );
    }

    private static void nonJava8Method(List<Integer> numbers) {
        int sum = 0;
        int counter = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int num = 0;

            if (numbers.get(i) % 2 == 0) {
                num = numbers.get(i) + 5;
            } else {
                sum += 0;
                continue;
            }

            num = num * 7;
            if (num % 20 == 3) {
                num = num / 20;
            }

            sum += (num / 10);

            if (++counter > 5) {
                break;
            }
        }

        System.out.println(sum);
    }

    /**
     *  Optional<T>
     */

    private static void exercise21(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                    .filter(num -> 2 == 1)
                    .filter(num -> num % 121 == 0)
                    .findAny()
                    .orElse(-1)
        );
    }
}
