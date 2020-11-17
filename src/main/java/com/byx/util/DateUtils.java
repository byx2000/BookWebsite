package com.byx.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils
{
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String daysAgo(int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -day);
        return format.format(calendar.getTime());
    }
}
