package com.example.glory.data.utils

import android.content.Context
import android.provider.CalendarContract
import com.example.glory.data.model.Event
import java.text.SimpleDateFormat
import java.util.*

fun getCalendarEvents(context: Context): List<Event> {
    val events = mutableListOf<Event>()
    val cursor = context.contentResolver.query(
        CalendarContract.Events.CONTENT_URI,
        arrayOf(CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART),
        null, null, null
    )

    cursor?.use {
        while (it.moveToNext()) {
            val title = it.getString(0) ?: "Untitled"
            val startMillis = it.getLong(1)

            val date = Date(startMillis)
            val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)

            events.add(
                Event(
                    title = title,
                    date = formattedDate,
                    recipient = ""
                )
            )
        }
    }

    return events
}

@Suppress("unused")
fun getDateWithSuffix(day: Int, recipient: String = ""): String {
    val suffix = when {
        day in 11..13 -> "th"
        day % 10 == 1 -> "st"
        day % 10 == 2 -> "nd"
        day % 10 == 3 -> "rd"
        else -> "th"
    }
    return if (recipient.isNotBlank()) "$recipient's $day$suffix" else "$day$suffix"
}

@Suppress("unused")
fun filterUpcomingWeekEvents(allEvents: List<Event>): List<Event> {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val today = Calendar.getInstance()
    val sevenDaysLater = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 7) }

    return allEvents.filter {
        try {
            val eventDate = sdf.parse(it.date)
            eventDate != null && eventDate.after(today.time) && eventDate.before(sevenDaysLater.time)
        } catch (_: Exception) {
            false
        }
    }
}