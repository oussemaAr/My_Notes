package com.odc.mynotes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.odc.mynotes.data.entity.Note
import io.reactivex.Completable


@Dao
public interface NoteDao {

    @Insert
    fun addNote(note: Note): Completable

    @Query("SELECT * FROM note_table")
    fun getAllNotes() : LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note): Completable

}