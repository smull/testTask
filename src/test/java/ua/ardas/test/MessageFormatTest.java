package ua.ardas.test;

import org.junit.Test;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static junit.framework.Assert.*;

/**
 * Created by SMULL on 9/20/2015.
 */
public class MessageFormatTest {

    @Test
    public void testTransferDateToLong() {
        MessageFormat messageFormat = new MessageFormat();
        Date date1 = new Date();
        date1.setHours(21);
        date1.setMinutes(35);
        long result = messageFormat.transferDateToLong(date1);

        assertEquals(70500000, result);
    }

    @Test
    public void determine() {
        MessageFormat messageFormat = new MessageFormat();
        ResourceBundle rb = ResourceBundle.getBundle("MyMessage", Locale.getDefault());

//      In order to check in ru locale
//        ResourceBundle rb = ResourceBundle.getBundle("MyMessage", new Locale("ru", "RU"));

        Date date1 = new Date();
        date1.setHours(21);
        date1.setMinutes(35);
        String message = messageFormat.determine(date1, rb);
        assertEquals(message, "Good evening, World!");
//        assertEquals(message, "Добрый вечер, Мир!");
    }
}
