package gb.karpenka.notes.services;

import gb.karpenka.notes.domain.Note;
import gb.karpenka.notes.exceptions.BadRequestException;
import gb.karpenka.notes.exceptions.NotFoundException;
import gb.karpenka.notes.repositories.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * Реализация интерфейса NoteService для работы с заметками.
 */

@Service
@RequiredArgsConstructor
public class NotesService {
    private final NotesRepository repository;

    /**
     * Получить все заметки.
     *
     * @return список всех заметок
     */
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    /**
     * Получить заметку по идентификатору.
     *
     * @param id идентификатор заметки
     * @return заметка с указанным идентификатором
     */
    public Note getNoteById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Заметка с id=" + id + " для отображения не найдена."));
    }

    /**
     * Создать новую заметку.
     *
     * @param note новая заметка
     * @return созданная заметка
     */
    public Note createNote(Note note) {
        Long id = note.getId();
        if (id != null){
            throw new BadRequestException(String.format("Заметка не создана. Можно создать заметку только без id(поле автоинкрементное)"));
        }
        note.setId(id);
        note.setCreationDateTime(LocalDateTime.now());
        return repository.save(note);
    }

    /**
     * Обновить существующую заметку.
     *
     * @param note обновленная заметка
     * @return обновленная заметка
     */
    public Note updateNote(Note note) {
        Long id = note.getId();
        if (id == null){
            throw new BadRequestException("Не указан id заметки для обновления.");
        }
        if (id != null && !repository.existsById(id)){
            throw new NotFoundException("Заметка с id=" + id + " для обновления не найдена.");
        }
        Note existingNote = getNoteById(id);
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        return repository.save(existingNote);
    }

    /**
     * Удалить заметку по идентификатору.
     *
     * @param id идентификатор заметки
     */
    public void deleteNote(Long id) {
        if (!repository.existsById(id)){
            throw new NotFoundException("Заметка с id=" + id + " для удаления не найдена.");
        }
        repository.deleteById(id);
    }
}
