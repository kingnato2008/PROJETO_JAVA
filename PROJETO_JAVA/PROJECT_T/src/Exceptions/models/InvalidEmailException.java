package Exceptions.models;

public class InvalidEmailException extends Exception{
	private String message;
	
	public InvalidEmailException(String message, String invalidEmail) {
		super(message);
		this.message=message+invalidEmail;
	}
	
	public String getMessage() {
		return message;
	}
}
