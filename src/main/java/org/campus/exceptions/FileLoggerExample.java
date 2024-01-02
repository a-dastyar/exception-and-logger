package org.campus.exceptions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileLoggerExample {

    static Logger log = LogManager.getLogger(FileLoggerExample.class);

    public static void logToNewFileEveryMin() throws InterruptedException{
        log.info("Logging to the first file");

        // Waiting for logger to switch files. 
        log.info("Sleeping for one minute ...");
        Thread.sleep(Duration.ofMinutes(1));

        log.info("Logging to the second file");
    }
}
