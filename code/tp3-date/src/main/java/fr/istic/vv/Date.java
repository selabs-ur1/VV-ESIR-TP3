package fr.istic.vv;

class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    /**
     * Constructs a Date object with the given day, month, and year.
     * Throws an AssertionError if the provided date is invalid.
     *
     * @param day   the day of the month
     * @param month the month (0 = January, 11 = December)
     * @param year  the year
     */
    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new AssertionError("Not a valid date");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Checks if the given day, month, and year form a valid date.
     *
     * @param day   the day of the month
     * @param month the month (0 = January, 11 = December)
     * @param year  the year
     * @return true if the date is valid, false otherwise
     */
    public static boolean isValidDate(int day, int month, int year) {
        if (year == 0) return false;
        if (day <= 0) return false;
        if (month < 0 || month > 11) return false;
        return day <= getMaxMonth(month, year);
    }

    /**
     * Returns the maximum number of days for the given month and year.
     *
     * @param month the month (0 = January, 11 = December)
     * @param year  the year
     * @return the maximum number of days in the given month
     */
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

    /**
     * Determines if the given year is a leap year.
     *
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else return year % 4 == 0;
    }

    /**
     * Returns the day of this Date.
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the year of this Date.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month of this Date.
     *
     * @return the month (0 = January, 11 = December)
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns a new Date representing the next day.
     *
     * @return the next Date
     */
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

    /**
     * Returns a new Date representing the previous day.
     *
     * @return the previous Date
     */
    public Date previousDate() {
        if (isValidDate(getDay() - 1, getMonth(), getYear())) {
            return new Date(getDay() - 1, getMonth(), getYear());
        }
        else if (getMonth() > 0) {
            int month = getMonth() - 1;
            int maxPreviousMonth = getMaxMonth(month, getYear());
            return new Date(maxPreviousMonth, month, getYear());
        } else if (getYear() == 1) {
            return new Date(31, 11, -1);
        }

        return new Date(31, 11, getYear() - 1);
    }

    /**
     * Compares this Date to another Date.
     *
     * @param other the other Date to compare to
     * @return a positive integer if this Date is after the other, a negative integer if before, and 0 if equal
     * @throws NullPointerException if the other Date is null
     */
    public int compareTo(Date other) {
        if (other == null) throw new NullPointerException();
        else if (getYear() != other.getYear()) return Integer.compare(getYear(), other.getYear());
        else if (getMonth() != other.getMonth()) return Integer.compare(getMonth(), other.getMonth());
        else return Integer.compare(getDay(), other.getDay());
    }

}