package model;

public class StringException extends Exception {
    public StringException (String str) {
        super("Problems with entry: " +  str);
    }
    public static class EmptyStringException extends StringException {
        public EmptyStringException() {
            super("You can not write empty strings.");
        }
    }
    public static class SignException extends StringException {
        public SignException() {
            super("Your sign should have at least 4 and at last 8 characters!");
        }
    }
}
