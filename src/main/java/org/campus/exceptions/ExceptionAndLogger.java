package org.campus.exceptions;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionAndLogger {

    static Logger log = LogManager.getLogger(ExceptionAndLogger.class);
 
    public static void main(String[] args) throws InterruptedException {
        handleException();
        
        // Sleeps 1 minute between logs so logger switch files as per config.
        FileLoggerExample.logToNewFileEveryMin();
    }


    private static void handleException() {
        var countries = new HashMap<String, Country>();
        countries.put("IRN", new Country("Iran", "IRN", 87_590_873));
        countries.put("IRQ", new Country("Iraq", "IRQ", 43_324_000));
        countries.put(null, new Country("India", null, 1_428_627_663));
        countries.put("USA", new Country("U.S. America", "USA", 334_914_895));
        countries.put("IRN", new Country("Iran", "IRN", 87_590_873));

        for (var mapEntry : countries.entrySet()) {
            try {
                printCountry(mapEntry.getValue());
            } catch (InvalidCountryCodeException e) {
                log.error(String.format("Invalid country code for {%s}", mapEntry.getValue().name()), e);
            }
        }
        System.out.println("\n --------------------------------------------------- \n");
    }

    public static void printCountry(Country country) {
        if (country.code() == null || country.code().isEmpty()) {
            throw new InvalidCountryCodeException();
        }
        System.out.println(country);
    }
}
