package fr.istic.vv;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) { 
        if(!isValidDate(day, month, year)){
            throw new IllegalArgumentException("Invalid arguments"); 
        }
        else{
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static boolean isValidDate(int day, int month, int year) { 
        int[] month31 = {1,3,5,7,8,10,12};
        if (year != 0 && month > 0 && month < 13 && day > 0) {
            if(day < 29) return true;
            else if(month == 2 && isLeapYear(year) && day < 30) return true;
            else if(day < 31 && month != 2) return true;
            else if(day < 32){
                for(int j : month31){
                    if(j == month) return true;
                }
            }
        }
        return false;
     }

    public static boolean isLeapYear(int year) { return (year%4 == 0 && year%100 != 0) || year%400 == 0 ; }

    public Date nextDate() { 
        if(isValidDate(day+1, month, year)) return new Date(day+1, month, year);
        else if(isValidDate(1, month+1, year)) return new Date(1, month+1, year);
        else if(isValidDate(1, 1, year+1)) return new Date(1, 1, year+1);
        else return new Date(1, 1, 1);
     }

    public Date previousDate() { 
        if(isValidDate(day-1, month, year)) return new Date(day-1, month, year);
        else if(isValidDate(31, month-1, year)) return new Date(31, month-1, year);
        else if(isValidDate(30, month-1, year)) return new Date(30, month-1, year);
        else if(isValidDate(29, month-1, year)) return new Date(29, month-1, year);
        else if(isValidDate(28, month-1, year)) return new Date(28, month-1, year);
        else if(isValidDate(31, 12, year-1)) return new Date(31, 12, year-1);
        else return new Date(31, 12, -1);
     }

    public int compareTo(Date other) { 
        if(other == null) throw new NullPointerException();
        int date1 = this.year * 10000 + this.month * 100 + this.day;
        int date2 = other.year * 10000 + other.month * 100 + other.day;
        return date1 - date2;
     }

}