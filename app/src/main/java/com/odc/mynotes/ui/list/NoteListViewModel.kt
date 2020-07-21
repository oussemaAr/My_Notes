package com.odc.mynotes.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.odc.mynotes.data.entity.Note
import com.odc.mynotes.repository.NoteRepository

class NoteListViewModel(application: Application) : AndroidViewModel(application) {

    fun getNote(): LiveData<List<Note>> {
        return NoteRepository(getApplication()).getAllNotes()
    }

}