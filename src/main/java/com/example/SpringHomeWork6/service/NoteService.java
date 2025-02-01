package com.example.SpringHomeWork6.service;

import com.example.SpringHomeWork6.model.Note;
import com.example.SpringHomeWork6.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Note updateNote(Note note) {
        Note noteById = getNoteById(note.getId());

        noteById.setTitle(note.getTitle());
        noteById.setContent(note.getContent());

        return repository.save(noteById);
    }

    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        repository.delete(noteById);
    }
}
