package com.example.glory.data.utils

import android.content.Context
import android.provider.ContactsContract
import com.example.glory.data.model.Event

fun getBirthdayEvents(context: Context): List<Event> {
    val events = mutableListOf<Event>()
    val uri = ContactsContract.Data.CONTENT_URI
    val selection = "${ContactsContract.Data.MIMETYPE} = ? AND ${ContactsContract.CommonDataKinds.Event.TYPE} = ?"
    val selectionArgs = arrayOf(
        ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE,
        ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY.toString()
    )

    val cursor = context.contentResolver.query(uri, null, selection, selectionArgs, null)
    cursor?.use {
        while (it.moveToNext()) {
            val name = it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            val date = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE))

            events.add(
                Event(
                    title = "Birthday",
                    date = date ?: "",
                    recipient = name ?: ""
                )
            )
        }
    }
    return events
}

