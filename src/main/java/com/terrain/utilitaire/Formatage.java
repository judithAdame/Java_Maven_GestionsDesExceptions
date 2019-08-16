package com.terrain.utilitaire;

import static com.terrain.utilitaire.MsgErreur.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.*;
import java.util.Date;
import java.util.Locale;

/**
 * @author Rova
 */
public class Formatage {
    //$, arrondissement, date
    ////https://stackoverflow.com/questions/6016501/parsing-a-currency-string-in-java
    ///https://stackoverflow.com/questions/2201925/converting-iso-8601-compliant-string-to-java-util-date
    
    public static double ParseCurrency(String s) throws ParseException{
        String regex = "[^\\d.-]+";
        String newStr = s.replace(",", ".");
        newStr = newStr.replaceAll(regex, "");
        double resultat = Double.parseDouble(newStr);
        //System.out.println("String s: "+s + " resultat: "+resultat);
        if(resultat <0){
            throw new ParseException(MSG_PARSECURRENCY,0);
        }
        return resultat;
    }
    
    public static String FormatCurrency(double d){
        String resultat = String.format("%.2f", d);
        resultat = resultat.replace(",", ".");
        //System.out.println("double d: "+d + " resultat: "+resultat);
        return resultat + " $";
    }
    
    public static Date ParseDate(String s) throws ValidationException, ParseException{
        String formatISO8601 = "yyyy-MM-dd";
        if (!(isValidFormat(formatISO8601, s, Locale.CANADA_FRENCH)))
            throw new ValidationException(MSG_LOT_DMESURE, s);
        SimpleDateFormat format = new SimpleDateFormat(formatISO8601);
        return format.parse(s);     
    }
    
    private static boolean isValidFormat(String format, String value, Locale locale) {
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);
        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                }
            }
        }
        return false;
    }
}
