package com.odc.mynotes.ui.detail

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.odc.mynotes.R
import com.odc.mynotes.data.entity.Note
import com.odc.mynotes.databinding.ActivityDetailsBinding
import com.odc.mynotes.utils.timeAgo
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


		// ViewBinding

		val binding = ActivityDetailsBinding.inflate(layoutInflater)
		setContentView(binding.root)


		val note = intent.getSerializableExtra("data") as Note

		binding.mTitle.text = note.title
		binding.description.text = note.description
		binding.time.text = timeAgo(note.createAt)
		Glide.with(this)
			.load(Uri.parse(note.image))
			.into(binding.image)

	}
}
