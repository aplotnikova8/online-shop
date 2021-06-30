package shop.utils;

import lombok.experimental.UtilityClass;
import shop.utils.constants.PaymentType;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@UtilityClass
public class Generator {

    private static Random random = new Random();

    public static String generateIntNumber(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateDoubleNumber() {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(random.nextInt(1000) + random.nextDouble());
    }

    public static boolean generateBoolean() {
        return random.nextBoolean();
    }

    public static String generateWord() {
        Character[] alphabet = IntStream.rangeClosed('a', 'z')
                .mapToObj(var -> (char) var)
                .toArray(Character[]::new);

        StringJoiner joiner = new StringJoiner("");

        for (int i = 0; i < 20; i++) {
            joiner.add(alphabet[random.nextInt(alphabet.length - 1)].toString());
            if (i >= 2 && alphabet[random.nextInt(alphabet.length - 1)] % 10 == 0) {
                break;
            }
        }
        return joiner.toString();
    }

    public static String generateString() {
        StringJoiner joiner = new StringJoiner(" ");
        IntStream.rangeClosed(1, 2).mapToObj(i -> Generator.generateWord()).forEach(joiner::add);
        if (Generator.generateBoolean()) {
            joiner.add(Generator.generateWord());
        }
        return joiner.toString();
    }

    private static List<String> addAllPaymentTypeInList() {
        List<String> list = Arrays.stream(PaymentType.values())
                .filter(type -> !PaymentType.GC.equals(type))
                .map(type -> PaymentType.GC + " and " + type)
                .collect(Collectors.toList());

        Arrays.stream(PaymentType.values()).map(PaymentType::toString)
                .forEach(list::add);

        return list;
    }

    public static String generatePaymentType() {
        List<String> list = Generator.addAllPaymentTypeInList();
        return list.get(random.nextInt(list.size() - 1));
    }

    private static void generateTime(Calendar date) {
        date.set(Calendar.HOUR, random.nextInt(24));
        date.set(Calendar.MINUTE, random.nextInt(60));
        date.set(Calendar.SECOND, random.nextInt(60));
    }

    private static void generateDay(Calendar date) {
        List<Integer> week = Stream.iterate(date.get(Calendar.DAY_OF_MONTH), n -> n - 1)
                .limit(7)
                .collect(Collectors.toList());
        date.set(Calendar.DAY_OF_MONTH, week.get(random.nextInt(7)));
    }

    public static void generateDate(Calendar date) {
        Generator.generateTime(date);
        Generator.generateDay(date);
    }

}
