package Exceptions.models;

public class InvalidAgeException extends Exception{
	private String message;
	
	public InvalidAgeException(String message, Integer invalidAge) {
		super(message);
		this.message=message+invalidAge;
	}
	
	public String getMessage() {
		return message;
	}
}
