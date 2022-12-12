public class InvalidPhoneNumberFormatException extends IllegalArgumentException {
    String message = "Неверный формат телефонного номера";

    @Override
    public String getMessage() {
        return message;
    }
}
