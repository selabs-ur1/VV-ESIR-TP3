package fr.istic.vv;

class Date implements Comparable<Date> {

    int m_day;
    int m_month;
    int m_year;

    public Date(int day, int month, int year) {
        this.m_day = day;
        this.m_month = month;
        this.m_year = year;
     }


    
    public static boolean isValidDate(int day, int month, int year) {
        
        if (day < 1 || month < 1) return false;

        if (month == 2 && day > 29 && !isLeapYear(year)){
            return false;
        }

        if (is31Day(month) && day <= 31){
            return true;
        }
        else if (day <= 30){
            return true;
        }

        return false; 
    }

    public static boolean isLeapYear(int year) { 
        
        if (year % 400 == 0 && year % 100 == 0){
            return true;
        }
        else if (year % 4 == 0 && year % 100 != 0){
            return true;
        }

        return false; 
    }

    public static boolean is31Day(int month){
        int[] longMonth = {1,3,5,7,8,10,12};

        for (int i=0; i<longMonth.length; i++){

            if (longMonth[i] == month){
                return true;
            }
        }
        
        return false;

    }

    public Date nextDate() { 
        
        if (m_month == 2 && m_day == 29 && !isLeapYear(m_year)){
            return new Date(1, 3, m_year);
        }

        if (m_day == 31 && m_month == 12){
            return new Date(1, 1, m_year+1);
        }

        if (m_day < 31 && is31Day(m_month) || m_day < 30 && !is31Day(m_month)){
            return new Date(m_day+1, m_month, m_year);
        }

        return new Date(1, m_month+1, m_year); 
    }

    public Date previousDate() {
         
        if (m_month == 3 && m_day == 1 && !isLeapYear(m_year)){
            return new Date(29, 2, m_year);
        }

        if (m_day == 1 && m_month == 1){
            return new Date(31, 12, m_year-1);
        }

        if ( m_day == 1){
            if (is31Day(m_month-1)){
                return new Date(31, m_month-1, m_year);
            }
            else {
                return new Date(30, m_month-1, m_year);
            }
        }
        
        return new Date(m_day-1, m_month, m_year); 
        }

    public int compareTo(Date other) { 
        
        if (other == null) throw new NullPointerException();
        if (m_day == other.m_day && m_month == other.m_month && m_year == other.m_year){

            return 0;
        } 

        if (m_year > other.m_year) return 1;
        if (m_month > other.m_month) return 1;
        if (m_day > other.m_day) return 1;
        
        return -1;
    }


}