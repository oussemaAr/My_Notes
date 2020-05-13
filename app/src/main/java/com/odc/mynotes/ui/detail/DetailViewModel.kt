package com.odc.mynotes.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.odc.mynotes.data.db.NoteDB
import com.odc.mynotes.data.entity.Note

class DetailViewModel(application: Application) : AndroidViewModel(application) {


    fun getDetails(id: Int): LiveData<Note> {
        return NoteDB.getDatabase(getApplication() as Application).getDao().getNoteById(id)
    }
}
