package com.example.base.helpers;

import java.sql.Timestamp;
import java.util.Calendar;

public class Utils {
    public static Timestamp createTimestamp() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp((calendar.getTime()).getTime());
    }
}
