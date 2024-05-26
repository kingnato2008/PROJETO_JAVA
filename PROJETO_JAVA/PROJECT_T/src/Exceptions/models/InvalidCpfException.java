package Exceptions.models;

public class InvalidCpfException extends Exception{
	private String message;
	
	public InvalidCpfException(String message, String invalidCpf) {
		super(message);
		this.message=message+invalidCpf;
	}
	
	public String getMessage() {
		return message;
	}
}
