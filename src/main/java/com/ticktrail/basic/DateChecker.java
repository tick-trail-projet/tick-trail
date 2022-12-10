package com.ticktrail.basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe correspondant a la date
 */
public class DateChecker {
    private String date;

    public DateChecker(String date) {
        this.date = date;
    }

    public boolean isValid() {
        Map<String, Integer> decompose = this.decompose();
        if (decompose.get("year") < Integer.parseInt(new SimpleDateFormat("yyyy")
                .format(Calendar.getInstance().getTime()))) {
            return false;
        }

        if (decompose.get("year") == Integer.parseInt(new SimpleDateFormat("yyyy")
                .format(Calendar.getInstance().getTime()))
                && decompose.get("month") < Integer.parseInt(new SimpleDateFormat("MM")
                        .format(Calendar.getInstance().getTime()))) {
            return false;
        }

        if (decompose.get("year") == Integer.parseInt(new SimpleDateFormat("yyyy")
                .format(Calendar.getInstance().getTime()))
                && decompose.get("month") == Integer.parseInt(new SimpleDateFormat("MM")
                        .format(Calendar.getInstance().getTime()))
                && decompose.get("day") < Integer.parseInt(new SimpleDateFormat("dd")
                        .format(Calendar.getInstance().getTime()))) {
            return false;
        }

        return true;
    }

    public Map<String, Integer> decompose() {
        Map<String, Integer> map = new HashMap<>();
        Integer years = Integer.parseInt(this.getDate().split("-")[0]);
        Integer months = Integer.parseInt(this.getDate().split("-")[1]);
        Integer days = Integer.parseInt(this.getDate().split("-")[2].split(" ")[0]);
        map.put("year", years);
        map.put("month", months);
        map.put("day", days);
        return map;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateChecker date(String date) {
        setDate(date);
        return this;
    }

    public static void main(String[] args) {
        DateChecker dateChecker = new DateChecker("2013-12-10 20h");
        System.out.println(dateChecker.isValid());
    }
}
