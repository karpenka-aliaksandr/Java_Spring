package gb.karpenka.notes.exceptions;

/**
 * Исключение, которое генерируется, когда запрос составлен не верно.
 */
public class BadRequestException extends RuntimeException {
    /**
     * Конструктор исключения с указанным сообщением об ошибке.
     *
     * @param message сообщение об ошибке
     */
    public BadRequestException(String message) {
        super(message);
    }
}
