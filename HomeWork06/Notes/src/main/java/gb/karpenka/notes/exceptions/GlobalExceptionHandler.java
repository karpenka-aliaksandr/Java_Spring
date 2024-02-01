package gb.karpenka.notes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Глобальный обработчик исключений.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение NotFoundException.
     *
     * @param ex исключение NoteNotFoundException
     * @return ответ с сообщением об ошибке и статусом "Not Found"
     */
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Обрабатывает исключение BadRequestException.
     *
     * @param ex исключение BadRequestException
     * @return ответ с сообщением об ошибке и статусом "Not Found"
     */
    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<String> handleNotFoundException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
