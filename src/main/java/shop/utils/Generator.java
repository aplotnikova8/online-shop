package shop.utils;

import shop.data.PaymentType;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generator {

    private static Random random = new Random();

    public static String generateIntNumber(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append((int) (Math.random() * 10));
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

    private static String generateWord() {
        Character[] alp = IntStream.rangeClosed('a', 'z')
                .mapToObj(var -> (char) var)
                .toArray(Character[]::new);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            sb.append(alp[random.nextInt(alp.length-1)]);
            if (i>=2 & alp[random.nextInt(alp.length-1)] % 10 == 0) {
                break;
            }
        }
        return sb.toString();
    }

    public static String generateString() {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, 2).mapToObj(i -> Generator.generateWord() + " ").forEach(sb::append);
        if (Generator.generateBoolean()) {
            sb.append(Generator.generateWord());
        }
        return sb.toString().trim();
    }

    private static PaymentType generatePaymentType() {
       return PaymentType.values()[random.nextInt(PaymentType.values().length)];
    }


    public static List<String> addAllPaymentTypeInList() {
        List<String> list = Arrays.stream(PaymentType.values())
                .filter(pt -> !PaymentType.GC.equals(pt))
                .map(pt -> PaymentType.GC + " and " + pt)
                .collect(Collectors.toList());

         Arrays.stream(PaymentType.values()).map(PaymentType::toString)
                .forEach(list::add);

         return list;
    }

    public static String choosePaymentType() {
        List<String> list = Generator.addAllPaymentTypeInList();
        return list.get(random.nextInt(list.size()-1));
    }

    private static void generateTime(Calendar date) {
        date.set(Calendar.HOUR, random.nextInt(24));
        date.set(Calendar.MINUTE, random.nextInt(60));
        date.set(Calendar.SECOND, random.nextInt(60));
    }

    private static void generateDay(Calendar date) {
        List<Integer> week = Stream.iterate(date.get(Calendar.DAY_OF_MONTH), n ->  n - 1)
                .limit(7)
                .collect(Collectors.toList());
        date.set(Calendar.DAY_OF_MONTH, week.get(random.nextInt(7)));
    }

    public static void generateDate(Calendar date) {
        Generator.generateTime(date);
        Generator.generateDay(date);
    }

}
