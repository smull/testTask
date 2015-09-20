package ua.ardas.test;


import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by SMULL on 9/19/2015.
 */
public class Main {

    static final MessageFormat messageFormat = new MessageFormat();

    public static void main(String[] args) {
        Date d = new Date();
        MyLogger.getLogger().info("Date created");
//        My default locale is EN
        ResourceBundle rb = ResourceBundle.getBundle("MyMessage", Locale.getDefault());
        MyLogger.getLogger().log(Level.INFO, "Got properties and install locale");
        String message = messageFormat.determine(d, rb);
        messageFormat.display(message);


//        Action with ru Locale
//        ResourceBundle rb = ResourceBundle.getBundle("MyMessage", new Locale("ru", "RU"));
//        MyLogger.getLogger().log(Level.INFO, "Got properties and install locale");
//        String message = messageFormat.determine(d, rb);
//        messageFormat.display(message);

        MyLogger.getLogger().info("Action done");
    }
}
