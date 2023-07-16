package Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

   public static void formatDate() {
       LocalDate date = LocalDate.of(2023, Month.DECEMBER, 18);
       LocalTime time = LocalTime.of(11,01,30);
       LocalDateTime dateTime = LocalDateTime.of(date,time);

       var formatter0 = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
       System.out.println(dateTime.format(formatter0));

       var formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
       System.out.println(dateTime.format(formatter1));

   }
}
