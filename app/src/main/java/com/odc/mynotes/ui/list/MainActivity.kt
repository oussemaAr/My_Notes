package com.odc.mynotes.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.odc.mynotes.R
import com.odc.mynotes.ui.add.AddActivity
import com.odc.mynotes.ui.detail.DetailsActivity
import com.odc.mynotes.utils.data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private lateinit var adapter: NoteAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		adapter = NoteAdapter(data) {
			val intent = Intent(this, DetailsActivity::class.java)
			intent.putExtra("data", it)
			startActivity(intent)
		}
		recycler.adapter = adapter

		fab.setOnClickListener {
			startActivityForResult(Intent(this, AddActivity::class.java), 5001)
		}

	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		adapter.notifyDataSetChanged()
	}
}
