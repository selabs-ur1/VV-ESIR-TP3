package fr.istic.vv;

class Date implements Comparable<Date> {
	
	private static Integer[] nbJoursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public int day;
	public int month;
	public int year;

    public Date(int day, int month, int year) throws Exception { 
    	if(isValidDate(day, month, year)) {
    		this.day = day;
    		this.month = month;
    		this.year = year;
    	} else {
    		throw new Exception("La date n'est pas valide");
    	}
    }

    public static boolean isValidDate(int day, int month, int year) { 
    	if(month == 2  && isLeapYear(year) &&
    	   day > 0 && day < 30) {
    		return true;
    	}
    	
    	if(month > 0 && month < 13 &&
    		 day > 0 && day <= nbJoursParMois[month-1]) {
    		return true;
    	}
    	return false; 
    }

    public static boolean isLeapYear(int year) { 
    	return ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0;
    }

    public Date nextDate() throws Exception {
    	if(isLeapYear(this.year) && this.month == 2 && this.day == 29) {
    		return new Date(1, 3, this.year);
    	}
    	
    	if(this.day == nbJoursParMois[month-1]) {
    		if(this.month == 12) {
    			return new Date(1, 1, this.year+1);
    		} else {
    			return new Date(1, month+1, this.year);
    		}
    	} else {
    		return new Date(this.day+1, this.month, this.year);
    	}
    }

    public Date previousDate() throws Exception {
    	if(isLeapYear(this.year) && this.month == 3 && this.day == 1) {
    		return new Date(29, 2, this.year);
    	}
    	
    	if(this.day == 1) {
    		if(this.month == 1) {
    			return new Date(31, 12, this.year-1);
    		} else {
    			return new Date(nbJoursParMois[month-2], month-1, this.year);
    		}
    	} else {
    		return new Date(this.day-1, this.month, this.year);
    	}
    }

    public int compareTo(Date other) { 
    	return (this.year - other.year) * 400 + (this.month - other.month) * 31 + (this.day - other.day); 
    }
}
