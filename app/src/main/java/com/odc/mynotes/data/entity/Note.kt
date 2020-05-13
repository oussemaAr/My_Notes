package com.odc.mynotes.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
data class Note(
	@PrimaryKey(autoGenerate = true)
	val id: Int,

	val title: String,
	val description: String,
	val image: String,

	@ColumnInfo(name = "create_at")
	val createAt: Long
) : Serializable
