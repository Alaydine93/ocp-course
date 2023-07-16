package Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberFormatter {

    public static void formatNumbers(){
        double d = 1234.543;
        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(f1.format(d));

        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        System.out.println(f2.format(d));

        NumberFormat f3 = new DecimalFormat("Your balance $#,###,###,###.##");
        System.out.println(f3.format(d));
    }
}
