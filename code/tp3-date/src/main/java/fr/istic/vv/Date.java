package fr.istic.vv;

class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new AssertionError("Not a valid date");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year == 0) return false;
        if (day <= 0) return false;
        if (month < 0 || month > 11) return false;
        return day <= getMaxMonth(month, year);
    }

    private static int getMaxMonth(int month, int year) {
        switch (month) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            case 1:
                return isLeapYear(year) ? 29 : 28;

            default:
                throw new AssertionError("Not a valid month");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else return year % 4 == 0;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public Date nextDate() {
        if (isValidDate(getDay() + 1, getMonth(), getYear())) {
            return new Date(getDay() + 1, getMonth(), getYear());
        } else if (isValidDate(1, getMonth() + 1, getYear())) {
            return new Date(1, getMonth() + 1, getYear());
        } else if (getYear() == -1) {
            return new Date(1, 0, 1);
        }
        return new Date(1, 0, getYear() + 1);
    }

    public Date previousDate() {
        if (isValidDate(getDay() - 1, getMonth(), getYear())) {
            return new Date(getDay() - 1, getMonth(), getYear());
        }
        else if (getMonth() > 0) {
            int maxPreviousMonth = getMaxMonth(getMonth() - 1, getYear());
            return new Date(maxPreviousMonth, getMonth() - 1, getYear());
        } else if (getYear() == 1) {
            return new Date(31, 11, -1);
        }

        return new Date(31, 11, getYear() - 1);
    }

    public int compareTo(Date other) {
        if (other == null) throw new NullPointerException();
        else if (getYear() != other.getYear()) return Integer.compare(getYear(), other.getYear());
        else if (getMonth() != other.getMonth()) return Integer.compare(getMonth(), other.getMonth());
        else return Integer.compare(getDay(), other.getDay());
    }

}