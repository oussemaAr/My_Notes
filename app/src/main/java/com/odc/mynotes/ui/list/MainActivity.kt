package com.odc.mynotes.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.odc.mynotes.R
import com.odc.mynotes.ui.add.AddActivity
import com.odc.mynotes.ui.detail.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private lateinit var adapter: NoteAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// 1 create our viewModel
		val viewModel : NoteListViewModel = ViewModelProvider(MainActivity@this).get(NoteListViewModel::class.java)
		// 2 requesting the data from the ViewModel
		val data = viewModel.getNote()

		data.observe(this, Observer {
			adapter = NoteAdapter(it) {
				val intent = Intent(this, DetailsActivity::class.java)
				intent.putExtra("data", it)
				startActivity(intent)
			}
			recycler.adapter = adapter
		})


		fab.setOnClickListener {
			startActivityForResult(Intent(this, AddActivity::class.java), 5001)
		}

	}

}
