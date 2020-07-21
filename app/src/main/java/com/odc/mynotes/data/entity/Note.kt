package com.odc.mynotes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
data class Note(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	@ColumnInfo(name = "title")
	val title: String,
	val description: String,
	val image: String,
	val createAt: Long
) : Serializable
