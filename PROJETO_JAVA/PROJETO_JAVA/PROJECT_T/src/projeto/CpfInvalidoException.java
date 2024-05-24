package projeto;

public class CpfInvalidoException extends Exception{
    private String message = "O CPF inserido é inválido";

    @Override
    public String getMessage() {
        return message;
    }
}
