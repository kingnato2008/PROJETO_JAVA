package projeto;

public class IdadeInvalidaException extends Exception{
    private String message = "A idade inserida é inválida";

    @Override
    public String getMessage() {
        return message;
    }
}
