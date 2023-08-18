package org.example;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExamples {

    public static void printHelloByName() {
        var rb = ResourceBundle.getBundle("Zoo");
        String format = rb.getString("helloByName");
        System.out.println(MessageFormat.format(format, "Tom", "Jerry"));
    }

    public static void printMessageForEnCaVisitor() {
        Locale.setDefault(new Locale("en","US"));
        var locale = new Locale("en", "CA");
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.print(rb.getString("hello"));
        System.out.print(". ");
        System.out.print(rb.getString("name"));
        System.out.print(" ");
        System.out.print(rb.getString("open"));
        System.out.print(" ");
        System.out.print(rb.getString("visitors"));
    }

    public static void printUsFrWelcomeMessages() {
        var us = new Locale.Builder().setLanguage("en").setRegion("US").build();
        var fr = new Locale("fr", "FR");
        printWelcomeMessage(us);
        printWelcomeMessage(fr);
    }

    public static void printKeyFromPropertiesFile() {
        var us = new Locale("en", "US");
        var rb = ResourceBundle.getBundle("Zoo", us);
        rb.keySet().stream().map(k -> k + ": " + rb.getString(k)).forEach(System.out::println);
    }

    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello") +
                ", " + rb.getString("open"));
    }
}
