package com.example.glory.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.ListenableWorker.Result
import com.example.glory.data.utils.getCalendarEvents
import com.example.glory.data.utils.getBirthdayEvents

class WeeklySyncWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            val calendarEvents = getCalendarEvents(applicationContext)
            val birthdayEvents = getBirthdayEvents(applicationContext)

            // TODO: Save to DB or shared cache

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}
