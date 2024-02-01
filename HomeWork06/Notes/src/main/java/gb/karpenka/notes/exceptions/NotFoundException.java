package gb.karpenka.notes.exceptions;

/**
 * Исключение, которое генерируется, когда заметка не найдена.
 */
public class NotFoundException extends RuntimeException{

    /**
     * Конструктор исключения с указанным сообщением об ошибке.
     *
     * @param message сообщение об ошибке
     */
    public NotFoundException(String message) {
        super(message);
    }
}
