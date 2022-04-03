package fr.istic.vv;

public class NotValidDateException extends Exception {
	public NotValidDateException(int day, int month, int year) {
        super("the date: " + day + "/" + month + "/" + year  + " is not valid");
    }
}
