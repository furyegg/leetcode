package com.leecode;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class GetWeek {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(getWeekOfYear(time));
    }
    
    public static int getWeekOfYear(LocalDateTime date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }
}
