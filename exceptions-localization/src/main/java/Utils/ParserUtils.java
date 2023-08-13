package Utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParserUtils {

    public static void parseNumber() throws ParseException {
        String s = "40.45";
        var en = NumberFormat.getInstance(Locale.US);
        System.out.println(en.parse(s));

        var fr = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println(fr.parse(s));


    }
}
