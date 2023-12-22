package fr.istic.vv;

class Date implements Comparable<Date> {

    static class BadDateException extends RuntimeException {
        public BadDateException(String s) {
            super(s);
        }
    }
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year) {
        if (!isValidDate(day,month,year)) {
           throw new BadDateException("La date n'est pas valide");
        } else {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        // variables for lisibility
        boolean badYear = year <= 0;
        boolean badMonth = month <= 0 || month > 12;
        boolean badDay = day <= 0 || day > 31;
        if (badYear || badMonth || badDay) return false;
        boolean month30 = month == 4 || month == 6 || month == 9 || month == 11; // months which have 30 days
        if (month30 && day > 30) return false;
        boolean badFebruaryDate = month == 2 && ((isLeapYear(year) && day > 29) || (!isLeapYear(year) && day > 28));
        return !badFebruaryDate;
    }

    public static boolean isLeapYear(int year) {
        // une année bissextile est divisible par 4 mais pas par 100 sauf si elle est aussi divisible par 400
        return year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 );
    }

    public Date nextDate() {
        int nextDay;
        int nextMonth;
        int nextYear;
        boolean month30 = month == 4 || month == 6 || month == 9 || month == 11; // months which have 30 day
        // Cas pour lequel on démarre un nouveau mois
        boolean leapYear = isLeapYear(year);
        boolean endOfMonth = (month30 && day == 30) || (day == 31 && month != 12) || (month == 2 && ((leapYear && day == 29) || (!leapYear && day == 28)));
        if (endOfMonth)  {
            nextDay = 1;
            nextMonth = this.month + 1;
            nextYear = year;
        } else {
            // Cas pour lequel on démarre une nouvelle année
            boolean endOfYear = month == 12 && day == 31;
            if (endOfYear) {
                nextDay = 1;
                nextMonth = 1;
                nextYear = year + 1;
            } else { // Cas lambda
                nextDay = day + 1;
                nextMonth = month;
                nextYear = year;
            }
        }
        return new Date(nextDay, nextMonth, nextYear);
    }

    public Date previousDate() {
        int previousDay;
        int previousMonth;
        int previousYear;
        boolean previousMonth30 = month == 5 || month == 7 || month == 10 || month == 12; // months for which the previous month has 30 days
        // Cas pour lequel repart au mois précédent
        boolean leapYear = isLeapYear(year);
        if (this.day == 1)  {
            if (this.month == 1) { // On repart à l'année précédente
                previousDay = 31;
                previousMonth = 12;
                previousYear = this.year - 1;
            } else if(previousMonth30) {
                previousDay = 30;
                previousMonth = this.month - 1;
                previousYear = this.year;
            } else if(this.month == 3) {
                previousMonth = 2;
                previousYear = this.year;
                if(leapYear) {
                    previousDay = 29;
                } else {
                    previousDay = 28;
                }
            } else {
                previousDay = 31;
                previousMonth = this.month - 1;
                previousYear = this.year;
            }
        } else { // cas lambda
            previousDay = this.day - 1;
            previousMonth = this.month;
            previousYear = this.year;
        }
        return new Date(previousDay, previousMonth, previousYear);

    }

    public int compareTo(Date other) {
        if (other != null) {
            if (this.year < other.year) return 1; // this est antérieure à other
            if (this.year > other.year) return -1; // this est postérieure à
            // Si les années sont égales
            if (this.month < other.month) return 1;
            if (this.month > other.month) return -1;
            // Si les mois sont égaux
            if (this.day < other.day) return 1;
            if (this.day > other.day) return -1;
            return 0; // les dates sont identiques
        } else { // Si other est null, on renvoie une exception
            throw new NullPointerException("La date fournie est null");
        }
    }

}