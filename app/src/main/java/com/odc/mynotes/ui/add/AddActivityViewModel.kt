package com.odc.mynotes.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.odc.mynotes.data.db.NoteDB
import com.odc.mynotes.data.entity.Note
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddActivityViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(note: Note): Completable {

        return NoteDB.getDatabase((getApplication() as Application).applicationContext).getDao()
            .insert(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }


}