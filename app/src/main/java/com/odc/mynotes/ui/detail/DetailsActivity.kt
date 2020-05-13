package com.odc.mynotes.ui.detail

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.odc.mynotes.R
import com.odc.mynotes.utils.timeAgo
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val id = intent.extras?.getInt("data")

        ViewModelProvider(this)
            .get(DetailViewModel::class.java)
            .getDetails(id!!)
            .observe(this, Observer { note ->
                mTitle.text = note.title
                description.text = note.description
                time.text = timeAgo(note.createAt)
                Glide.with(this)
                    .load(Uri.parse(note.image))
                    .into(image)
            })
    }
}
