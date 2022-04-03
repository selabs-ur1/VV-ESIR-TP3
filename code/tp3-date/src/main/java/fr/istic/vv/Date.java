package fr.istic.vv;

class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;


	public Date(int day, int month, int year) throws Exception { 
		if(isValidDate(day,month,year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		} else throw new Exception("The date is not valid");
	}

	public static boolean isValidDate(int day, int month, int year) { 
		if(month<=0 || month >12 || day<=0 || day >31) {
			return false;
		} else if(!isLeapYear(year)) {
			if(month == 2) {
				return day<=28;
			} else if((month<=7 && month%2==1) || (month>7 && month%2==0)) {
				return day<=31;
			} else return day <=30;
		} else {	
			if(month == 2) {
				return day<=29;
			} else if((month<=7 && month%2==1) || (month>7 && month%2==0)) {
				return day<=31;
			} else return day <=30;
		}
	}

	public static boolean isLeapYear(int year) { return year%4==0; }

	public Date nextDate() throws Exception { 
		if(isValidDate(day+1,month,year)) {
			return new Date(day+1,month,year);
		} else if(isValidDate(1,month+1,year)) {
			return new Date(1,month+1,year);
		} else return new Date(1,1,year+1);
	}


	public Date previousDate() throws Exception { 
		if(isValidDate(day-1,month,year)) {
			return new Date(day-1,month,year);
		} else if(isValidDate(31,month-1,year)) {
			return new Date(31,month-1,year);
		} else if(isValidDate(30,month-1,year)) {
			return new Date(30,month-1,year);
		} else if(isValidDate(29, month-1, year)) {
			return new Date(29, month-1, year); 
		} else if(isValidDate(28, month-1, year)) {
			return new Date(28, month-1, year);
		} else return new Date(31, 12, year-1);
	}

	public int compareTo(Date other) { 
		if(year!=other.year) {
			return year - other.year;
		} else if(month!=other.month) {
			return month - other.month;
		} else if(day != other.day) {
			return day - other.day;
		} else return 0; 
	}

}