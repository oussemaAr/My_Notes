package com.odc.mynotes.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.odc.mynotes.data.db.NoteDB
import com.odc.mynotes.data.entity.Note

class ListNoteViewModel(application: Application) : AndroidViewModel(application) {

    private var _data: MutableLiveData<List<Note>> = MutableLiveData()
    private val data: LiveData<List<Note>> = _data

    fun getNotes(): LiveData<List<Note>> {
        return NoteDB.getDatabase((getApplication() as Application).applicationContext)
            .getDao()
            .getAllNotes()


    }
}