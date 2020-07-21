package com.odc.mynotes.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odc.mynotes.R
import com.odc.mynotes.data.entity.Note

class NoteAdapter(private val data: List<Note>, val listener: (Note) -> Unit) :
	RecyclerView.Adapter<NoteViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
		NoteViewHolder(
			LayoutInflater
				.from(parent.context)
				.inflate(
					R.layout.note_item, parent, false
				)
		)

	override fun getItemCount(): Int = data.size

	override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
		holder.bind(data[position])
		holder.itemView.setOnClickListener {
			listener(data[position])
		}
	}

}
