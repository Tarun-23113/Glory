package com.example.glory.services

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.Data
import androidx.work.ListenableWorker.Result
import com.example.glory.services.NotificationHelper

class ReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        val eventName = inputData.getString("event_name") ?: return Result.failure()
        NotificationHelper.showNotification(applicationContext, eventName)
        return Result.success()
    }
}