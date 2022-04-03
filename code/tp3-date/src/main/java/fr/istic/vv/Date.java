package fr.istic.vv;

class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;
	
	
    public Date(int day, int month, int year) throws Exception {
    	if(isValidDate(day, month, year)) {
    		this.day = day;
        	this.month = month;
        	this.year = year;
    	}
    	else {
    		throw new NotValidDateException(day, month, year);
    	}
    }

    public static boolean isValidDate(int day, int month, int year) {
    	if((day <= 0 || day > 31)) {
    		return false;
    	}
    	
    	if ((month <= 0 || month > 12)) {
    		return false;
    	}
    	
    	
    	//we consider neg year as false
    	if(year < 0){
    		return false;
    	}
    	
    	if(isA30dayMonth(month)) {
			if(day > 30) { return false; }
		}
    	
    	if(isFebruary(month)) {
    		if(isLeapYear(year)) {
    			if(day > 29) { return false; }
    		}
    		else {
    			if(day > 28 ) { return false; }
    		}
    	
    	}
    	
    	return true;
    }
    
    private static boolean isA31dayMonth(int month) {
    	int[] monthWith31Days = {1, 3, 5, 7, 8, 10, 12};
    	
    	for(int m : monthWith31Days) {
    		if (m == month){
    			return true;
    		}
    	}
    	return false;
    }
    
    private static boolean isA30dayMonth(int month) {
    	int[] monthWith30Days = {4, 6, 9, 11};
    	
    	for(int m : monthWith30Days) {
    		if (m == month){
    			return true;
    		}
    	}
    	return false;
    }
    
    private static boolean isFebruary(int month) {
    	return month == 2;
    }
    
    //A leap year is a year that is divisible by 4 and 400 without a remainder.
    public static boolean isLeapYear(int year) { 
    	
    	int remain4 = year % 4;
    	int remain400 = year % 400;
    	boolean isLeapYear = (remain4 == 0) && (remain400 == 0);
    	
    	return isLeapYear; 
    }

    public Date nextDate() throws Exception { 
    	//31ème jour du mois à 31 jour
    	//passage mois suivant et possible changement d'année
    	if(isA31dayMonth(month)) {
    		if(day == 31) {
    			int nextMonth = nextMonth(month);
    			if(nextMonth == 1) {
    				return new Date(1, nextMonth, year + 1);
    			}
    			else {
    				return new Date(1, nextMonth, year);
    			}
    		}
    	}
    	
    	//30ème jour du mois à 30jour
    	//passage mois suivant
    	if(isA30dayMonth(month)) {
    		return new Date(1, nextMonth(month), year);
    	}
    	
    	//28ème jour où 29 du mois de fevrier
    	//passage mois suivant
    	if(isFebruary(month)) {
    		if(isLeapYear(year)) {
    			if(day == 29) {
    				return new Date(1, nextMonth(month), year);
    			}
    		}
    		else {
    			if(day == 28) {
    				return new Date(1, nextMonth(month), year);
    			}
    		}
    	}
    	
    	//jour non final de moi --> on passe au jour suivant
    	return new Date(day + 1, month, year);
    }
    
    private static int nextMonth(int month) {
    	return (month % 12) + 1;
    }
    
    private static int previousMonth(int month) {
    	return (month == 1) ? 12 : month - 1 ;
    }
    
    private static int numberOfDayOfMonth(int month){
    	if(isA31dayMonth(month)) {
    		return 31;
    	}
    	if(isA30dayMonth(month)) {
    		return 30;
    	}
    	
    	if(isFebruary(month)) {
    		if(isLeapYear(month)) {
    			return 29;
    		}
    		else {
    			return 28;
    		}
    	}
    	
    	//ne doit pas arriver
    	return -1;
    }

    public Date previousDate() throws Exception { 
    	if(day == 1) {
    		int previousMonth = previousMonth(month);
    		if(previousMonth == 12) {
    			//on est le 1er janvier
    			return new Date(numberOfDayOfMonth(previousMonth), previousMonth, year - 1);
    		}
    		//on remonte juste d'un mois
    		return new Date(numberOfDayOfMonth(previousMonth), previousMonth, year);
    	}
    	
    	//jour lambda != 1
    	return new Date(day-1, month, year);
    }

    public int compareTo(Date other) { 
    	if(this.year > other.year) {
    		return 1;
    	}
    	
    	if(this.year < other.year) {
    		return -1;
    	}
    	
    	//same year
    	
    	if(this.month > other.month) {
    		return 1;
    	}
    	
    	if(this.month < other.month) {
    		return -1;
    	}
    	
    	//same year same month
    	
    	if(this.day > other.day) {
    		return 1;
    	}
    	
    	if(this.day < other.day) {
    		return -1;
    	}
    	
    	//same year same month same day
    	return 0;
    }

}