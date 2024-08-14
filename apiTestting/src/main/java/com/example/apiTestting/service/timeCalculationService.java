package com.example.apiTestting.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class timeCalculationService {
    public String calTimeDif (List<String> startTimeStrings , List<String> endTimeStrings , int length){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        long totalDays = 0;
        long totalHours = 0;
        long totalMinutes = 0;
        long totalSeconds = 0;

        for (int i = 0; i < length; i++) {
            LocalDateTime startTime = LocalDateTime.parse(startTimeStrings.get(i), formatter);
            LocalDateTime endTime = LocalDateTime.parse(endTimeStrings.get(i), formatter);

            Duration duration = Duration.between(startTime, endTime);

            long days = duration.toDays();
            long hours = duration.minusDays(days).toHours();
            long minutes = duration.minusDays(days).minusHours(hours).toMinutes();
            long seconds = duration.minusDays(days).minusHours(hours).minusMinutes(minutes).getSeconds();
            totalDays += duration.toDays();
            totalHours += duration.minusDays(duration.toDays()).toHours();
            totalMinutes += duration.minusDays(duration.toDays()).minusHours(duration.minusDays(duration.toDays()).toHours()).toMinutes();
            totalSeconds += duration.minusDays(duration.toDays()).minusHours(duration.minusDays(duration.toDays()).toHours()).minusMinutes(duration.minusDays(duration.toDays()).minusHours(duration.minusDays(duration.toDays()).toHours()).toMinutes()).getSeconds();
        }

        totalMinutes += totalSeconds / 60;
        totalSeconds = totalSeconds % 60;
        totalHours += totalMinutes / 60;
        totalMinutes = totalMinutes % 60;
        totalDays += totalHours / 24;
        totalHours = totalHours % 24;
        String ans = totalHours+" Hours "+totalMinutes+" minutes "+ totalSeconds+ " seconds ";
        if (totalDays == 0 ){
            return ans;
           // System.out.printf("%d hours,%d minutes,%d seconds%n", totalHours, totalMinutes, totalSeconds);
        }else{
          //  System.out.printf("%d days,%d hours,%d minutes,%d seconds%n", totalDays, totalHours, totalMinutes, totalSeconds);
            return totalDays + " days " + ans ;
        }
    }

    public String singleTimeCal ( String a , String b ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        long totalDays = 0;
        long totalHours = 0;
        long totalMinutes = 0;
        long totalSeconds = 0;
        LocalDateTime startTime = LocalDateTime.parse(a, formatter);
        LocalDateTime endTime = LocalDateTime.parse(b, formatter);

        Duration duration = Duration.between(startTime, endTime);
        long days = duration.toDays();
        long hours = duration.minusDays(days).toHours();
        long minutes = duration.minusDays(days).minusHours(hours).toMinutes();
        long seconds = duration.minusDays(days).minusHours(hours).minusMinutes(minutes).getSeconds();
        totalDays += duration.toDays();
        totalHours += duration.minusDays(duration.toDays()).toHours();
        totalMinutes += duration.minusDays(duration.toDays()).minusHours(duration.minusDays(duration.toDays()).toHours()).toMinutes();
        totalSeconds += duration.minusDays(duration.toDays()).minusHours(duration.minusDays(duration.toDays()).toHours()).minusMinutes(duration.minusDays(duration.toDays()).minusHours(duration.minusDays(duration.toDays()).toHours()).toMinutes()).getSeconds();
        totalMinutes += totalSeconds / 60;
        totalSeconds = totalSeconds % 60;
        totalHours += totalMinutes / 60;
        totalMinutes = totalMinutes % 60;
        totalDays += totalHours / 24;
        totalHours = totalHours % 24;
        String ans = totalHours+" Hours "+totalMinutes+" minutes "+ totalSeconds+ " seconds ";
        if (totalDays == 0 ){
            return ans;
            // System.out.printf("%d hours,%d minutes,%d seconds%n", totalHours, totalMinutes, totalSeconds);
        }else{
            //  System.out.printf("%d days,%d hours,%d minutes,%d seconds%n", totalDays, totalHours, totalMinutes, totalSeconds);
            return totalDays + " days " + ans ;
        }

    }
}
