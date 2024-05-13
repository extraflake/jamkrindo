package com.example.demo.handler;

import java.util.Calendar;

public class CustomCalendar {
    public static String getLastDayOfMonth(String dateStr) {
        String[] dateParts = dateStr.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return String.format("%02d", lastDay) + "-" + String.format("%02d", month) + "-" + dateParts[0];
    }
}
