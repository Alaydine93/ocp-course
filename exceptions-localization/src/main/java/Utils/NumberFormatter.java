package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Stream;

public class NumberFormatter {

    public static void compactFormatNumbers(){
        var formatters = Stream.of(NumberFormat.getCompactNumberInstance(),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG));

        formatters.map(s -> s.format(7_123_456)).forEach(System.out::println);
    }

    public static void formatNumbers(){
        double d = 1234.543;
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(f1.format(d));

        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        System.out.println(f2.format(d));

        NumberFormat f3 = new DecimalFormat("Your balance $#,###,###,###.##");
        System.out.println(f3.format(d));
    }

    public static void numberToCurrency() {
        double number = 50;
        var formatter = NumberFormat.getCurrencyInstance();
        System.out.println(formatter.format(50));
    }
}
