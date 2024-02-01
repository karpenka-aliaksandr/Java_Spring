package gb.karpenka.notes.controllers;

import gb.karpenka.notes.domain.Note;
import gb.karpenka.notes.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NotesController {
    private final NotesService notesService;

    /**
     * Получить все заметки.
     *
     * @return список всех заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    /**
     * Получить заметку по идентификатору.
     *
     * @param id идентификатор заметки
     * @return заметка с указанным идентификатором
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNotesById(@PathVariable Long id){
        return ResponseEntity.ok(notesService.getNoteById(id));
    }

    /**
     * Создать новую заметку.
     *
     * @param note новая заметка
     * @return созданная заметка
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.createNote(note));
    }

    /**
     * Обновить существующую заметку.
     *
     * @param note обновленная заметка
     * @return обновленная заметка
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return ResponseEntity.ok(notesService.updateNote(note));
    }

    /**
     * Удалить заметку по идентификатору.
     *
     * @param id идентификатор заметки
     * @return ответ без содержимого
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        return ResponseEntity.ok("Заметка с id=" + id + " удалена успешно");
    }


}
