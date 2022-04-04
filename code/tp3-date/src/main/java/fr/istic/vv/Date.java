package fr.istic.vv;

public class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;
    private static int[] tabThirty = {4,6,9,11};
    private static int[] tabThirtyOne = {1,3,5,7,8,10,12};

    /*
    * The constructor throws an exception if the three given integers do not form a valid date.
    */
    public Date(int day, int month, int year) throws Exception {
        if(!isValidDate(day, month, year)){
            throw new Exception(day + "/" + month + "/" + year + " is not a valid date");
        }
        else {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    } 

    /*
    * isValidDate returns true if the three integers form a valid year, otherwise false.
    */
    public static boolean isValidDate(int day, int month, int year) { 
        return 
        !(month >12 
        || (month==2 && day>29 && isLeapYear(year)) 
        || (month==2 && day>28 && !isLeapYear(year)) 
        || day < 1 
        || month <1 
        || year < 1
        || (isIn30(month) && day>30) 
        || (isIn31(month) && day>31));
    }

    /*
    * isLeapYear says if the given integer is a leap year.  
    */
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 );
    }

    /*
    * nextDate returns a new Date instance representing the date of the following day.
    */
    public Date nextDate() throws Exception {
        if(month != 2){
            if(isIn30(month)){
                if(day<30){
                    day++;
                }
                else {
                    month++;
                    day=1;
                }
            }
            else{
                if(day<31){
                    day++;
                }
                else if (month<12){
                    month++;
                    day=1;
                }
                else{
                    year++;
                    month=1;
                    day=1;
                }
            }
        }
        else{
            if(isLeapYear(year)){
                if(day<29){
                    day++;
                }
                else{
                    month++;
                    day=1;
                }
            }
            else{
                if(day<28){
                    day++;
                }
                else{
                    month++;
                    day=1;
                }
            }
        }
        return new Date(day, month, year);
    }

    /*
    * previousDate returns a new Date instance representing the date of the previous day.
    */
    public Date previousDate() throws Exception {
        if(day>1){
            day--;
        }
        else if (month>1){
            month--;
            if(isIn30(month)){
                day=30;
            }
            else if(isIn31(month)){
                day=31;
            }
            else if(isLeapYear(year)){
                day=29;
            }
            else{
                day=28;
            }

        }
        else if(year >1){
            year--;
            day=31;
            month=12;
        }
        else {
            throw new Exception("Error : a year can't be negative");
        }
        
        return new Date(day, month, year);
    }

    public int compareTo(Date other) {
        if(other==null)
        {
           throw new NullPointerException("The other date is null");
         }
        else if(day==other.getDay() && month==other.getMonth() && year==other.getYear())return 0;
        else if(year > other.getYear())return 1;
        else if(year==other.getYear() && month > other.getMonth()) return 1;
        else if (year==other.getYear() && month==other.getMonth() && day > other.getDay())return 1;
        else return -1;
      
    }
    
    //getters
    public int getDay() {return day;}
    public int getMonth() { return month;}
    public int getYear() {return year;}

    /*
    * check if a month has 30 days
    */
    private static boolean isIn30(int month){
        for (int element : tabThirty) {
            if (element == month) {
                return true;
            }
        }
        return false;
    }

    /*
    * check if a month has 31 days
    */
    private static boolean isIn31(int month){
        for (int element : tabThirtyOne) {
            if (element == month) {
                return true;
            }
        }
        return false;
    }

}
