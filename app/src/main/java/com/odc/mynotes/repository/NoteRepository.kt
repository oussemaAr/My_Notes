package com.odc.mynotes.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.odc.mynotes.data.db.NoteDB
import com.odc.mynotes.data.entity.Note
import io.reactivex.Completable


// one single truth
class NoteRepository(private val context: Context) {

    fun insert(note: Note): Completable {
        return NoteDB.initInstance(context).dao()
            .addNote(note)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return NoteDB.initInstance(context).dao().getAllNotes()
    }

}