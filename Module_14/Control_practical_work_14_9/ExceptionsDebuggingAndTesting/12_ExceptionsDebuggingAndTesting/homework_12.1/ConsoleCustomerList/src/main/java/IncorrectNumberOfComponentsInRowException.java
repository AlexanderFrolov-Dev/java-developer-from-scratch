public class IncorrectNumberOfComponentsInRowException extends IllegalArgumentException {
    String message = "Введенная команда содержит неверное количество элементов";

    @Override
    public String getMessage() {
        return message;
    }
}
