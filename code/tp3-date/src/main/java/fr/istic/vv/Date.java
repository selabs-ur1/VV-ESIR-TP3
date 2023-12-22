package fr.istic.vv;

import java.util.LinkedList;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) throw new IllegalArgumentException("Invalid date");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {

        if ((month < 1 || month > 12)) return false;

        if(day < 1) return false;

        if(month == 2){
            if(isLeapYear(year)) return (day <= 29);
            return (day <= 28);
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);list.add(6);list.add(9);list.add(11);

        if(list.contains(month)){
            return (day <= 30);

        }else {
            return (day <= 31);
        }

    }

    public static boolean isLeapYear(int year) {

        if(year % 4 == 0) {
            if(year % 100 == 0) {
                return ((year % 400) == 0);
            }
            return true;
        }

        return false;
    }

    public Date nextDate() {
        if (!isValidDate(day, month, year)) throw new IllegalArgumentException("Invalid date");
        int day = this.day;
        int month = this.month;
        int year = this.year;

        if((day == 31) || (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) || (day == 28 && month == 2 && !isLeapYear(year)) || (day == 29 && month == 2 && isLeapYear(year))) {
            day = 1;
            month++;
            if (month == 13) {
                month = 1;
                year++;
            }

        } else day++;

        return new Date(day, month, year);


    }

    public Date previousDate() {
        if (!isValidDate(day, month, year)) throw new IllegalArgumentException("Invalid date");
        int day = this.day;
        int month = this.month;
        int year = this.year;

        if(day == 1 && month == 3) {
            if(isLeapYear(year)) day = 29;
            else day = 28;
            month--;
        } else if(day == 1){
            if(month == 5 || month == 7 || month == 10 || month == 12){
                day = 30;
            } else {
                day = 31;
            }
            month--;
        } else day--;

        if(month == 0){
            year--;
            month = 12;
        }

        return new Date(day, month, year);
    }

    public int compareTo(Date other) {
        if (!isValidDate(day, month, year)) throw new IllegalArgumentException("Invalid date");
        if (!isValidDate(other.day, other.month, other.year)) throw new IllegalArgumentException("Invalid date");

        if(this.year < other.year) return -1;
        if(this.year > other.year) return 1;

        if(this.month < other.month) return -1;
        if(this.month > other.month) return 1;

        return Integer.compare(this.day, other.day);

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}