public class InvalidEmailFormatException extends IllegalArgumentException {
    String message = "Неверный формат email";

    @Override
    public String getMessage() {
        return message;
    }
}
