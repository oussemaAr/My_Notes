package com.odc.mynotes.ui.list

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.odc.mynotes.data.entity.Note
import com.odc.mynotes.utils.timeAgo
import kotlinx.android.synthetic.main.note_item.view.*
import java.io.File

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

	fun bind(note: Note) = with(itemView) {
		title_layout.text = note.title
		description.text = note.description
		create_at.text = timeAgo(note.createAt)
		Glide.with(this)
			.load(Uri.parse(note.image))
			.into(picture)
	}

}
