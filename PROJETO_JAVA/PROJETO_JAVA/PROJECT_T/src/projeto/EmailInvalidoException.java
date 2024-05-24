package projeto;

public class EmailInvalidoException extends Exception{
    private String message = "O e-mail inserido é inválido";

    @Override
    public String getMessage() {
        return message;
    }
}
