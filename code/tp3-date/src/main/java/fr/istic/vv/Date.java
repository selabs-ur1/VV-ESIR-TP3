package fr.istic.vv;

class Date implements Comparable<Date> {

	int day;
	int month;
	int year;

	static int[] dayInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Date(int day, int month, int year) throws Exception {
		if (!isValidDate(day, month, year)) {
			throw new Exception("The date is not valid");
		}
		this.day = day;
		this.month = month;
		this.year = year;

	}

	public static boolean isValidDate(int day, int month, int year) {
		if (isLeapYear(year)) {
			dayInMonth[1] = 29;
		} else {
			dayInMonth[1] = 28;
		}
		if (month > 12 || month<=0) {
			return false;

		}
		if (day > dayInMonth[month-1] || day<=0) {
			return false;
		}

		return true;
	}

	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	public Date nextDate() throws Exception {
		if(day+1>dayInMonth[this.month-1]) {
			if(this.month==12) {
				return new Date(1,1,this.year+1);
			}
			return new Date(1,this.month+1,this.year);
		}
		return new Date(this.day+1,this.month,this.year);
	}

	public Date previousDate() throws Exception {
		if(this.day-1<=0) {
			if(this.month-1<=0) {
				return new Date(dayInMonth[11],12,this.year-1);
			}
			return new Date(dayInMonth[this.month-2],this.month-1,this.year);
		}
		return new Date(this.day-1,this.month,this.year);
	}

	public int compareTo(Date other) {
		if(other==null) throw new NullPointerException();
		int dateAsInteger = this.day+this.month*100+this.year*10000;
		int otherdateAsInteger = other.day+other.month*100+other.year*10000;
		return dateAsInteger-otherdateAsInteger;
	}


}