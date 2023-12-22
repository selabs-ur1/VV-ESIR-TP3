package fr.istic.vv;

class Date implements Comparable<Date> {

    private final int day;
    private final int month;
    private final int year;
    public Date(int day, int month, int year) {
        validateDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }
        int daysInMonth = (month == 2) ? (isLeapYear(year) ? 29 : 28) : getDaysInMonth(month);
        return day <= daysInMonth;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public Date nextDate() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;

        if (nextDay > getDaysInMonth(nextMonth)) {
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
            prevDay = getDaysInMonth(prevMonth);
        }

        return new Date(prevDay, prevMonth, prevYear);
    }

    @Override
    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException("L'objet 'other' ne peut pas être nul");
        }

        int yearComparison = Integer.compare(this.year, other.year);
        if (yearComparison != 0) {
            return yearComparison;
        }

        int monthComparison = Integer.compare(this.month, other.month);
        if (monthComparison != 0) {
            return monthComparison;
        }

        return Integer.compare(this.day, other.day);
    }

    private static void validateDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Votre Date est Invalide");
        }
    }

    private static int getDaysInMonth(int month) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Date other = (Date) obj;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    public int getDay() {
        return day;
    }
}