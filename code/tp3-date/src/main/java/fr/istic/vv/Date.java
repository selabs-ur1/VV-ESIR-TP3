package fr.istic.vv;

class Date implements Comparable<Date> {
	
	public int d, m, y;

    public Date(int day, int month, int year) throws Exception 
    {
    	if (isValidDate(day,month,year))
    	{
        	d= day;
        	m = month;
        	y = year;
    	}
    	else
    	{
    		throw new Exception("The date is not valid");
    	}
    }

    public static boolean isValidDate(int day, int month, int year) 
    { 
    	boolean validMonth = month > 0 && month < 13;
    	
    	if (!validMonth)
    	{return false;}
    	
    	boolean validDay = day > 0 && day < nbMaxOfDays(day,month,year) + 1 ;
    	
    	return validDay; 
    }
    
    private static int nbMaxOfDays(int day, int month, int year)
    {
    	int nb;
    	if (month == 4 || month == 6 || month == 9 || month == 11)
    	{
    		nb = 30;
    	}
    	else if (month == 2)
    	{
    		if (isLeapYear(year))
    		{
    			nb = 29;
    		}
    		else
    		{
    			nb = 28;
    		}
    	}
    	else
    	{
    		nb = 31;
    	}
    	
    	return nb;
    }

    public static boolean isLeapYear(int year) 
    { 
    	return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public Date nextDate() throws Exception 
    { 
    	int day,month,year;
    	int finMois = nbMaxOfDays(d,m,y);
    	
    	if (d+1 > finMois)
    	{
    		day = 1;
    		if (m+1 > 12)
    		{
    			month = 1;
    			year = y+1;
    		}
    		else
    		{
    			month = m+1;
    			year = y;
    		}
    	}
    	else
    	{
    		day = d+1;
    		month = m;
    		year = y;
    	}
    		
    	return new Date(day,month,year); 
    }

    public Date previousDate() throws Exception 
    { 
    	int day,month,year;
    	
    	if (d-1 < 1)
    	{
    		if (m == 1)
    		{
    			day = 31;
    			month = 12;
    			year = y-1;
    		}
    		else
    		{
    			day = nbMaxOfDays(d,m-1,y);
    			month = m-1;
    			year = y;
    		}
    	}
    	else
    	{
    		day = d-1;
    		month = m;
    		year = y;
    	}
    		
    	return new Date(day,month,year);
    }

    public int compareTo(Date other) 
    { 
    	if (other == null)
    	{throw new NullPointerException("other is null");}
    	
    	if (y > other.y)
    	{return 1;}
    	if (y < other.y)
    	{return -1;}
    	
    	if (m > other.m)
    	{return 1;}
    	if (m < other.m)
    	{return -1;}
    	
    	if (d > other.d)
    	{return 1;}
    	if (d < other.d)
    	{return -1;}
    	
    	return 0; 
    }

}