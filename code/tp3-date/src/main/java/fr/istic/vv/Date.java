package fr.istic.vv;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    private static List<Integer> months30 = Arrays.asList(4,6,9,11);

    public Date(int day, int month, int year) throws Exception{
        if(!isValidDate(day,month,year))
            throw  new Exception("Error Invalid Date");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if(day<1 || month>12 || month<1)return false;
        if(months30.contains(month)){
            if(day>30)return false;
        }
        else{
            if(day>31)return false;
        }
        if(isLeapYear(year)){
            if(month == 2 && day>29)return false;
        }
        else if(month == 2 && day>28)return false;

        return true;
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public Date nextDate() throws Exception{
        if(isValidDate(day+1,month, year)){
            return new Date(day+1,month, year);
        }
        else if (isValidDate(01,month+1,year)){
            return new Date(01,month+1, year);
        }
        else{
            return new Date(01,01,year+1);
        }
    }

    public Date previousDate() throws Exception{
        int newMonth = 0;
        if(month-1 == 2){
            if(isLeapYear(year))newMonth = 29;
            else newMonth = 28;
        }
        else if(months30.contains(month-1))newMonth = 30;
        else newMonth = 31;

        if(isValidDate(day-1,month, year)){
            return new Date(day-1,month, year);
        }
        else if (isValidDate(newMonth,month-1,year)){
            return new Date(newMonth,month-1, year);
        }
        else{
            return new Date(newMonth,12,year-1);
        }
    }

    public int compareTo(Date other){
        if(other == null)throw new NullPointerException();

        if(this.year>other.year)return 1;

        else if(this.year<other.year)return -1;

        else{
            if(this.month>other.month)return 1;

            else if(this.month<other.month)return -1;

            else{
                if(this.day>other.day)return 1;
                else if(this.day<other.day)return -1;
                else return 0;
            }
        }
    }

}