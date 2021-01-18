package model;

public class StringException extends Exception {
    public StringException (String str) {
        super("Problemas com a entrada das informações: " +  str);
    }
    public static class EmptyStringException extends StringException {
        public EmptyStringException() {
            super("Você não pode deixar espaços vazios.");
        }
    }
    public static class SignException extends StringException {
        public SignException() {
            super("Sua senha deve ter no mínimo 4 e no máximo 8 caracteres!");
        }
    }
}
