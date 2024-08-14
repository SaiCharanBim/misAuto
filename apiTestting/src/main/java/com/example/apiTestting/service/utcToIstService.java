package com.example.apiTestting.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class utcToIstService {


   public String utcToIst(String utc) {
     /*   try {
            Instant instant;
            // Try parsing with an adjusted ISO-8601 format that adds 'Z' for UTC
            try {
                if (utc.endsWith("Z")) {
                    instant = Instant.parse(utc);
                } else if (utc.contains(".")) {
                    // Adding 'Z' assuming input is UTC if fractional seconds are present
                    instant = Instant.parse(utc + "Z");
                } else {
                    // Handle cases where there's no 'Z' or timezone info by appending 'Z'
                    instant = Instant.parse(utc + "Z");
                }
            } catch (DateTimeParseException isoException) {
                System.out.println("ISO-8601 parse failed: " + isoException.getMessage());

                // If all else fails, handle as a custom ISO-8601 without fractional seconds or timezone
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
                            .withZone(ZoneId.of("UTC"));
                    instant = formatter.parse(utc, Instant::from);
                } catch (DateTimeParseException customException) {
                    System.out.println("Custom format parse failed: " + customException.getMessage());
                    return null;
                }
            }

            // Convert Instant to ZonedDateTime in IST
            ZonedDateTime istTime = instant.atZone(ZoneId.of("Asia/Kolkata"));

            // Define the output formatter for IST in 24-hour format
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Format the IST ZonedDateTime to a string
            return istTime.format(outputFormatter);

        } catch (Exception e) {
            // Catch any unexpected exceptions
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
        */
       Instant instant = Instant.parse(utc);
       ZonedDateTime istTime = instant.atZone(ZoneId.of("Asia/Kolkata"));
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy' 'HH:mm:ss");
       return istTime.format(formatter);

    }



    public String readableUtcToIst ( String time  ) {


        try {
            // Log the received input for debugging
            System.out.println("Received input time: '" + time + "'");

            // Define the input formatter for parsing the input date-time string
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a", Locale.US);

            // Print input formatter pattern and locale for debugging
            System.out.println("Input Formatter Pattern: M/d/yyyy, h:mm:ss a");
            System.out.println("Locale: " + Locale.getDefault());

            // Parse the string to LocalDateTime assuming the input time is in UTC
            LocalDateTime localDateTimeUTC = LocalDateTime.parse(time.trim(), inputFormatter);

            // Log the parsed LocalDateTime for debugging
            System.out.println("Parsed LocalDateTime UTC: " + localDateTimeUTC);

            // Convert LocalDateTime to ZonedDateTime in UTC
            ZonedDateTime utcDateTime = localDateTimeUTC.atZone(ZoneId.of("UTC"));

            // Convert the UTC ZonedDateTime to IST ZonedDateTime
            ZonedDateTime istDateTime = utcDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));

            // Define the output formatter for IST in 24-hour format
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Format the IST ZonedDateTime to a string
            String formattedIstTime = istDateTime.format(outputFormatter);
            System.out.println("Formatted IST time: " + formattedIstTime);

            return formattedIstTime;

        } catch (DateTimeParseException e) {
            // Log the error and stack trace for debugging
            System.err.println("Time Format Error: " + time);
            e.printStackTrace();
            return "Time Format Error: " + time;
        }

    }

    public static String formatToDoubleDigits(String dateTime) {
        try {
            // Split the date and time parts
            String[] dateTimeParts = dateTime.split(" ");
            String[] dateParts = dateTimeParts[0].split("/");
            String[] timeParts = dateTimeParts[1].split(":");

            // Parse and format the date components
            int month = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            // Parse and format the time components
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = Integer.parseInt(timeParts[2]);

            // Format the components to ensure two digits for day, month, hour, minute, second
            String formattedDate = (month < 10 ? "0" : "") + month + "/"
                    + (day < 10 ? "0" : "") + day + "/"
                    + year;

            String formattedTime = (hour < 10 ? "0" : "") + hour + ":"
                    + (minute < 10 ? "0" : "") + minute + ":"
                    + (second < 10 ? "0" : "") + second;

            // Concatenate the formatted date and time
            return formattedDate + " " + formattedTime;

        } catch (Exception e) {
            // Handle any parsing errors
          //  System.out.println("Error parsing date: " + e.getMessage());
            return dateTime;
        }
    }

}
