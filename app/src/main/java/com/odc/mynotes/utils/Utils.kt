package com.odc.mynotes.utils

import android.text.format.DateUtils
import com.odc.mynotes.data.entity.Note

fun timeAgo(timestamp: Long): String = DateUtils.getRelativeTimeSpanString(timestamp).toString()

var data = ArrayList<Note>()
