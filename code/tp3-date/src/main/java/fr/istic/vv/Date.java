package fr.istic.vv;

class Date implements Comparable<Date> {
	
	private int day;
	private int month;
	private int year;

    public Date(int day, int month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) { 
    	if (day < 0 || month < 0 || year == 0) {
    		return false;
    	}
    	switch (month) {
	    	case 1:
	    	case 3:
	    	case 5:
	    	case 7:
	    	case 8:
	    	case 10:
	    	case 12:
	    		return day < 32;
	    	case 2:
	    		if (isLeapYear(year)) { return day < 30; } else { return day < 29; }
	    	case 4:
	    	case 6:
	    	case 9:
	    	case 11:
	    		return day < 31;
	    	default:
	    		return false;
    	}
    }

    public static boolean isLeapYear(int year) { 
    	return year % 4 == 0 && year % 100 != 0;
    }

    public Date nextDate() {
    	if (!isValidDate(this.day, this.month, this.year)) { return null; }
    	
    	int newDay = this.day;
    	int newMonth = this.month;
    	int newYear = this.year;
    	
    	switch (month) {
	    	case 12:
	    		if (day == 31) {
	    			newMonth = 1;
	    			newYear += 1;
	    		}
	    		break;
	    	case 2:
	    		if (!isLeapYear(newYear) && day == 28) {
	    			newMonth += 1;
	    		} else if (isLeapYear(newYear) && day == 29) {
	    			newMonth += 1;
	    		}
	    		break;
	    	case 1:
	    	case 3:
	    	case 5:
	    	case 7:
	    	case 8:
	    	case 10:
	    		if (day == 31) newMonth += 1;
	    		break;
	    	case 4:
	    	case 6:
	    	case 9:
	    	case 11:
	    		if (day == 30) newMonth += 1;
	    		break;
    	}
    	
    	if (month != newMonth) {
    		newDay = 1;
    	} else {
    		newDay += 1;
    	}
    	
    	if (newYear == 0) {
    		newYear += 1;
    	}
    	
    	return new Date(newDay, newMonth, newYear);
    }

    public Date previousDate() { 
    	if (!isValidDate(this.day, this.month, this.year)) { return null; }
    	
    	int newDay = this.day;
    	int newMonth = this.month;
    	int newYear = this.year;
    	
    	newDay -= 1;
    	
    	if (newDay < 1) {
    		newMonth -= 1;
    		if (newMonth < 1) {
    			newMonth = 12;
    			newYear -= 1;
    			if (newYear == 0) {
    				newYear = -1;
    			}
    		}
    		switch (month) {
	    		case 2:
	    			if (isLeapYear(newYear)) {
	    				newDay = 29;
	    			} else {
	    				newDay = 28;
	    			}
	    			break;
	    		case 1:
	    		case 3:
	    		case 5:
	    		case 7:
	    		case 8:
	    		case 10:
	    		case 12:
	    			newDay = 31;
	    			break;
	    		default:
	    			newDay = 30;
	    			break;
    		}
    	}
    	
    	return new Date(newDay, newMonth, newYear);
    }

    public int compareTo(Date other) {
    	if (!isValidDate(other.day, other.month, other.year) || !isValidDate(this.day, this.month, this.year))
    		{ throw new RuntimeException("Cannot compare invalid values"); }
    	
    	if (this.year > other.year) { return 1; }
    	if (this.year < other.year) { return -1; }
    	
    	if (this.month > other.month) { return 1; }
    	if (this.month < other.month) { return -1; }
    	
    	if (this.day > other.day) { return 1; }
    	if (this.day < other.day) { return -1; }
    	
    	return 0;
    }

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

}