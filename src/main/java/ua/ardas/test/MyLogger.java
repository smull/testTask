package ua.ardas.test;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by SMULL on 9/20/2015.
 */
public class MyLogger {

    private static Logger logger = null;

    private MyLogger() {
    }

    public static synchronized Logger getLogger(){
        if (logger == null){
            logger = Logger.getLogger("MyLog");
            FileHandler fh = null;
            File myPath = new File("C://logs");
            if (!myPath.exists())
                myPath.mkdir();
            try {
                //This block configure the logger with handler and formatter
                fh = new FileHandler("C://logs/MyLogFile.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }
}
