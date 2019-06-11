package net.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */

/**
 * @author S425401
 *
 */
public class TimeDifference {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String dateStart = "31/12/2016 19:59";
        String dateStop = "04/01/2017 01:10";

        long delay = 999999999 * 4;

        System.err.println("delay=" + delay);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;
        int diffMinutes = (int) (diff / (60 * 1000) % 60);
        int diffHours = (int) (diff / (60 * 60 * 1000));
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time in hours: " + diffHours + " hours.");

        Calendar temp = Calendar.getInstance();
        temp.setTime(d2);
        temp.add(Calendar.HOUR, diffHours);
        temp.add(Calendar.MINUTE, diffMinutes);

        System.out.println("Next trigger = " + temp.getTime());

        temp.add(Calendar.HOUR, diffHours);
        temp.add(Calendar.MINUTE, diffMinutes);
        System.out.println("Next trigger 2= " + temp.getTime());

        temp.add(Calendar.HOUR, diffHours);
        temp.add(Calendar.MINUTE, diffMinutes);
        System.out.println("Next trigger 3= " + temp.getTime());

        temp = Calendar.getInstance();
        temp.setTime(d1);
        temp.add(Calendar.HOUR, diffHours * -1);
        temp.add(Calendar.MINUTE, diffHours * -1);

        System.out.println("First trigger = " + temp.getTime());


    }

}
