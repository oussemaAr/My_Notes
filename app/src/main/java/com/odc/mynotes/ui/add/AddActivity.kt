package com.odc.mynotes.ui.add

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.odc.mynotes.R
import com.odc.mynotes.data.entity.Note
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add.*
import java.io.IOException
import java.util.*

class AddActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 5001
    private lateinit var filePath: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        note_image.setOnClickListener {
            choosePicture()
        }

        val viewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        save.setOnClickListener {
            val note = Note(
                0,
                title = note_title.text.toString(),
                description = note_description.text.toString(),
                image = filePath.toString(),
                createAt = Date().time
            )

            viewModel.createNote(note)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Action {
                    setResult(Activity.RESULT_OK)
                    finish()
                })

        }
    }

    private fun choosePicture() {
        val intent = Intent()
        intent.apply {
            type = "image/*"
            action = Intent.ACTION_OPEN_DOCUMENT
        }
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data?.data != null) {
            filePath = data.data!!
            contentResolver.takePersistableUriPermission(
                filePath,
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            )
            try {
                val bitmap =
                    MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                note_image.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
