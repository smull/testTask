package ua.ardas.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;


/**
 * Created by SMULL on 9/19/2015.
 */
public class MessageFormat {

    public static long SIX = 14400000L;
    public static long NINE = 25200000L;
    public static long NINETEEN = 61200000L;
    public static long TWENTY_THREE = 75600000L;

    public static SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

    public String determine(Date date, ResourceBundle rs) {
        MyLogger.getLogger().log(Level.INFO, "In method");
        long timeNow = transferDateToLong(date);
        if (timeNow >= SIX && timeNow < NINE) {
            MyLogger.getLogger().log(Level.INFO, "Out method");
            return rs.getString("morning");
        } else if (timeNow >= NINE && timeNow < NINETEEN) {
            MyLogger.getLogger().log(Level.INFO, "Out method");
            return rs.getString("day");
        } else if (timeNow >= NINETEEN && timeNow < TWENTY_THREE) {
            MyLogger.getLogger().log(Level.INFO, "Out method");
            return rs.getString("evening");
        } else {
            MyLogger.getLogger().log(Level.INFO, "Out method");
            return rs.getString("night");
        }
    }


    public long transferDateToLong(Date date) {
        MyLogger.getLogger().log(Level.INFO, "In method");
        String now = parser.format(date);
        Date today = null;
        try {
            today = parser.parse(now);
            MyLogger.getLogger().log(Level.INFO, "Got format of date to compare");
        } catch (ParseException e) {
            MyLogger.getLogger().log(Level.SEVERE, "ParseException", e);
            e.printStackTrace();
        }
        MyLogger.getLogger().log(Level.INFO, "Out method");
        return today.getTime();
    }

    public void display(String print){
        System.out.println(print);
    }
}
