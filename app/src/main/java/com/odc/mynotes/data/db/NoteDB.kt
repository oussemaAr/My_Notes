package com.odc.mynotes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.odc.mynotes.data.dao.NoteDao
import com.odc.mynotes.data.entity.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB : RoomDatabase() {

    abstract fun dao() : NoteDao

    companion object{
        private var instance: NoteDB? = null

        fun initInstance(context: Context): NoteDB {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(context, NoteDB::class.java, "note_db")
                    .build()
            }
            return instance!!
        }
    }
}