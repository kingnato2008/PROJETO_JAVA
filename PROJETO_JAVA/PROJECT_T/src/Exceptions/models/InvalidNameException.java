package Exceptions.models;

public class InvalidNameException extends Exception{
    private String message;
    
   public InvalidNameException(String message, String invalidName) {
	   super(message);
	   this.message=message + invalidName;
   }

    public String getMessage() {
    	return message;
    }
}
