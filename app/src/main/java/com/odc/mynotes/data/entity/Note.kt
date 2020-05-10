package com.odc.mynotes.data.entity

import java.io.Serializable

data class Note(
	val id: Int,
	val title: String,
	val description: String,
	val image: String,
	val createAt: Long
) : Serializable
