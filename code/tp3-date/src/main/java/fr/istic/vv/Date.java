package fr.istic.vv;

class Date implements Comparable<Date> {

    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1) {
            return false;
        }
        else if(month < 1){
            return false;
        }
        else if(month > 12){
            return false;
        }
        else if(day < 1){
            return false;
        }
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        
        if (day > daysInMonth[month - 1]) {
            return false;
        }
        
        return true;
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
    }

    public Date nextDate() {
        int day = this.day;
        int month = this.month;
        int year = this.year;
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31,
                             30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        
        day++;
        
        if (day > daysInMonth[month - 1]) {
            day = 1;
            month++;
        }
        
        if (month > 12) {
            month = 1;
            year++;
        }
        
        return new Date(day, month, year);
    }

    public Date previousDate() {
        int day = this.day;
        int month = this.month;
        int year = this.year;
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31,
                             30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        
        day--;
        
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            day = daysInMonth[month - 1];
        }
        
        return new Date(day, month, year);
    }

    public int compareTo(Date other) {
        if(other==null){
            throw new NullPointerException("other is null");
        }
        if(this.year>other.year){
            return 1;
        }
        else if(this.year<other.year){
            return -1;
        }
        else {
            if(this.month>other.month){
                return 1;
            }
            else if(this.month<other.month){
                return -1;
            }
            else{
                if(this.day>other.day){
                    return 1;
                }
                else if(this.day<other.day){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}