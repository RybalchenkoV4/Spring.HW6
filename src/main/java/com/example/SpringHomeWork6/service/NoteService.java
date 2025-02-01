package com.example.SpringHomeWork6.service;

import com.example.SpringHomeWork6.model.Note;
import com.example.SpringHomeWork6.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository repository;

    public List<Note> getAllNote() {
        return repository.findAll();
    }

    public Note getNoteById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public Note createNote(Note note) {
        return repository.save(note);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> optionalNote = repository.findById(id);
        if(optionalNote.isPresent()){
            Note note = optionalNote.get();
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            return repository.save(note);
        } else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }

    public void deleteNote(Long id) {
        repository.delete(id);
    }
}
