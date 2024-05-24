package projeto;

public class NomeInvalidoException extends Exception{
    private String message = "O nome inserido é inválido";

    @Override
    public String getMessage() {
        return message;
    }
}
