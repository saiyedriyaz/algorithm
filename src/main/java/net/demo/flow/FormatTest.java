package net.demo.flow;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.TimeZone;

public class FormatTest {
    public static void main(String[] args) {
        /*Currency plnC = Currency.getInstance("INR");//getInstance(Locale.getDefault());
        System.out.println(plnC.getDisplayName());
        System.out.println(plnC.getSymbol());
        System.out.println(plnC.getCurrencyCode());

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "NL"));
        System.out.println(numberFormat.format(125.78));
*/
        /*LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println(ldt.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("dd-MMM-YYYY HH:mm:ss:SSSS")));*/

        /*TimeZone dTimeZone = TimeZone.getDefault();
        TimeZone mTimeZone = TimeZone.getTimeZone("IST");
        System.out.println(dTimeZone.getDisplayName()+":"+dTimeZone.getDSTSavings());
        System.out.println(mTimeZone.getDisplayName()+":"+mTimeZone.getDSTSavings());

        ZonedDateTime euZdt = ZonedDateTime.now(ZoneId.of("CET"));
        System.out.println(euZdt);

        ZonedDateTime indianZdt = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(indianZdt);

        System.out.println(Timestamp.valueOf(LocalDateTime.now()));

        System.out.println(NumberFormat.getInstance().format(123456.789));
        System.out.println(NumberFormat.getNumberInstance().format(123456.789));
        System.out.println(NumberFormat.getCurrencyInstance().format(123456.789));
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "NL")).format(123456.789));
        NumberFormat numberFormat = NumberFormat.getInstance();*/

        Locale.setDefault(Locale.Category.FORMAT, Locale.CANADA_FRENCH);
        System.out.println(NumberFormat.getInstance().format(123456.789));

        Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
        //Locale.setDefault(new Locale("en","IN"));
        System.out.println(NumberFormat.getInstance().format(123456.789));
    }
}
