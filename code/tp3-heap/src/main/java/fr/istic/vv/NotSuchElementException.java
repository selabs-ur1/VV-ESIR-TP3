package fr.istic.vv;

public class NotSuchElementException extends Exception {

	private static final long serialVersionUID = -8630807155598007554L;
	
	public String getMessage() {
		return "Error, this action wasn't possible";
	}
	
}
