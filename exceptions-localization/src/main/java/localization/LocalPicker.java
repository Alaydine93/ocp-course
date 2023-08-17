package localization;

import java.util.Locale;

public class LocalPicker {

    public static void main(String... args){
        System.out.println("before change : " + Locale.getDefault());
        System.out.println(Locale.GERMAN);
        System.out.println(Locale.GERMANY);

        var locale1 = new Locale.Builder().setLanguage("fr").setRegion("CA").build();
        Locale.setDefault(locale1);
        System.out.println("after change : " + Locale.getDefault());
    }
}
