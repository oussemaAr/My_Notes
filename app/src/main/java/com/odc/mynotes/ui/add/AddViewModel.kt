package com.odc.mynotes.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.odc.mynotes.data.entity.Note
import com.odc.mynotes.repository.NoteRepository
import io.reactivex.Completable

class AddViewModel(application: Application) : AndroidViewModel(application) {

    fun createNote(note: Note): Completable {
        return NoteRepository(getApplication()).insert(note)
    }
}