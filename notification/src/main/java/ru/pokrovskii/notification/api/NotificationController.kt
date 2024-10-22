package ru.pokrovskii.notification.api

import android.app.NotificationChannel

interface NotificationController {

    fun createChannel(
        id: String,
        name: String,
    ) : NotificationChannel

    fun showNotification(
        title: String,
        message: String,
        notificationChannelId: String,
    )
}