package com.odc.mynotes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.odc.mynotes.data.entity.Note
import io.reactivex.Completable

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note): Completable

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note_table WHERE id = :id")
    fun getNoteById(id: Int): LiveData<Note>

    @Query("DELETE FROM note_table WHERE id = :id")
    fun deleteNoteByID(id: Int)

    @Delete
    fun deleteNote(note: Note)

}