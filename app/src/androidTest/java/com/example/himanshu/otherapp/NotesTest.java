package com.example.himanshu.otherapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.himanshu.otherapp.RoomDB.Note;
import com.example.himanshu.otherapp.RoomDB.NoteStore;
import com.example.himanshu.otherapp.RoomDB.NotesDatabase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class NotesTest {

    NotesDatabase db;
    NoteStore noteStore;

    @Before
    public void setUp(){
        db = NotesDatabase.create(InstrumentationRegistry.getContext(),true);
        noteStore = db.noteStore();
    }
    @After
    public void destroy(){
        db.close();
    }
    @Test
    public void check(){
        assertEquals(0,noteStore.selectAll().size());
        final Note note= new Note("This is a Note","This is the details");
        assertNotNull(note.id);
        assertNotEquals(0,note.id.length());
        noteStore.insert(note);
        assertNote(noteStore,note);

        final Note note2 = new Note(note.id,"This is note 2","This are updated details!");
        noteStore.update(note2);

        assertNote(noteStore,note2);

        noteStore.delete(note2);
        assertEquals(0,noteStore.selectAll().size());
    }

    private void assertNote(NoteStore noteStore, Note note) {
        List<Note> result = noteStore.selectAll();
        assertNotNull(result);
        assertEquals(1,result.size());
        assertTrue(areIdentical(note,result.get(0)));
    }

    private boolean areIdentical(Note note, Note note1) {
        return (note.id.equals(note1.id))&&(note.getTitle().equals(note1.getTitle()))&&note.getText().equals(note1.getText());
    }
}