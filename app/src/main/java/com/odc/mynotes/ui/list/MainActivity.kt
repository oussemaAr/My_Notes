package com.odc.mynotes.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.odc.mynotes.R.layout.activity_main
import com.odc.mynotes.data.db.NoteDB
import com.odc.mynotes.data.entity.Note
import com.odc.mynotes.ui.add.AddActivity
import com.odc.mynotes.ui.detail.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private lateinit var adapter: NoteAdapter


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(activity_main)

		val listNote = ArrayList<Note>()
		NoteDB.getDatabase(this).getDao().getAllNotes().observe(this, Observer {
			listNote.clear()
			listNote.addAll(it)
			adapter.notifyDataSetChanged()
		})

		adapter = NoteAdapter(listNote) {
			val intent = Intent(this, DetailsActivity::class.java)
			intent.putExtra("data", it.id)
			startActivity(intent)
		}
		recycler.adapter = adapter

		fab.setOnClickListener {
			startActivity(Intent(this, AddActivity::class.java))
		}

	}
}
