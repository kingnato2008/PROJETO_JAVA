package Exceptions.models;

public class InvalidCodeException extends Exception{
	private String message;
	
	public InvalidCodeException(String message, int invalidCod) {
		super(message);
		this.message=message+invalidCod;
	}
	
	public String getMessage() {
		return message;
	}

}
