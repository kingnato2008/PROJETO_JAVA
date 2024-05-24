package projeto;

public class CodigoInvalidoException extends Exception{
    private String message = "O código inserido é inválido";

    @Override
    public String getMessage() {
        return message;
    }
}
