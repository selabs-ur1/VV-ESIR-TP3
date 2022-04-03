package fr.istic.vv;

class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;
	
	// 01, 03, 05, 07, 08, 10, 12		-> 31 jours
	// 04, 06, 09, 11 					-> 30 jours
	// 02								-> 28 ou 29 jours
	
	
    public Date(int day, int month, int year) throws Exception{ 
    	if(!isValidDate(day,month,year)) {
    		throw new Exception("Error : Invalid Date");
    	}
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
    	if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    		if(day <= 31 && day > 0) {
    			return true;
    		}
    	} else  if(month == 4 || month == 6 || month == 9 || month == 11) {
    		if(day <= 30 && day > 0) {
    			return true;
    		}
    	} else if(month == 2) {
    		if(isLeapYear(year)) {
    			if(day <= 29 && day > 0) {
    				return true;
    			}
    		} else {
    			if(day <= 28 && day > 0) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }

    public static boolean isLeapYear(int year) { 
    	if(year%4 == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public Date nextDate() throws Exception { //A refaire trop compliqué
    	if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) && day == 31) {
    		return new Date(1, month+1, year);
    	} else if(month == 12 && day == 31) {
    		return new Date(1,1,year+1);
    	} else if((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
    		return new Date(1, month+1, year);
    	} else if(isLeapYear(year)) {
    		if(month == 2 && day == 29) {
    			return new Date(1, month+1, year);
    		}
    	} else {
    		if(month == 2 && day ==28) {
    			return new Date(1, month+1, year);
    		}
    	}
    	return new Date(day+1, month, year);
    	}

    public Date previousDate() throws Exception { 
    	if((month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11) && day == 1) {
    		return new Date(31,month-1, year);
    	} else if(month == 1 && day == 1) {
    		return new Date(31,12,year-1);
    	} else if((month == 5 || month == 7 || month == 10 || month == 12) && day == 1) {
    		return new Date(30, month-1, year);
    	} else if(month == 2 && day == 1) { // reste que le mois de février (2)
    		if(isLeapYear(year)) {
    			return new Date(29, month-1, year);
    		} else {
    			return new Date(28, month-1, year);
    		}
    	} else {
    		return new Date(day-1, month, year);
    	}
    }

    public int compareTo(Date other) { 
    	if(this.year < other.getYear()) {
    		return -1;
    	} else if(this.year > other.getYear()) {
    		return 1;
    	} else {	// this.year == other.year
    		if(this.month < other.getMonth()) {
    			return -1;
    		} else if(this.month > other.getMonth()) {
    			return 1;
    		} else {	// this.month == other.month && this.year == other.year
    			if(this.day < other.getDay()) {
    				return -1;
    			} else if(this.day > other.getDay()) {
    				return 1;
    			} else {	//this.day == other.day && this.month == other.month && this.day == other.day
    				return 0;
    			}
    		}
    	}
    }
    
    //Getter
    
    public int getDay() { return this.day; }
    public int getMonth() { return this.month; }
    public int getYear() { return this.year; }
}