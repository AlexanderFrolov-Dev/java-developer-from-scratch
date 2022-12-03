public class IncorrectNameFormatException extends IllegalArgumentException {
    String message = "Неверный формат имени и фамилии";

    @Override
    public String getMessage() {
        return message;
    }
}
