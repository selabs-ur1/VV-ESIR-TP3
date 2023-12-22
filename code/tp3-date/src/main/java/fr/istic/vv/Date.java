package fr.istic.vv;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) { 
        if(!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    private static int daysInMonth(int month, int year) { 
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31,
                             30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // February has 29 days in a leap year
        }
        return daysInMonth[month - 1];
    }

    public static boolean isValidDate(int day, int month, int year) { 
        // a month and a day can't be inferior to 1, there are 12 months in a year.
        // for a year it depends on the use cases, but negative years do exists in the gregorian calendar
         if (month < 1 || month > 12 || day < 1) {
            return false;
        }

        return day <= daysInMonth(month, year);
    }

    public static boolean isLeapYear(int year) { 
        //a leap year is divisible by 4 but not by 100, or is divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public Date nextDate() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;

        if (nextDay > daysInMonth(nextMonth, nextYear)) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }
        return new Date(nextDay, nextMonth, nextYear);
     }

    public Date previousDate() { 
        int prevDay = day - 1;
        int prevMonth = month;
        int prevYear = year;

        if (prevDay < 1) {
            prevMonth--;
            if (prevMonth < 1) {
                prevMonth = 12;
                prevYear--;
            }
            prevDay = daysInMonth(prevMonth, prevYear);
        }
        return new Date(prevDay, prevMonth, prevYear);
     }

    public int compareTo(Date other) { 
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }
}