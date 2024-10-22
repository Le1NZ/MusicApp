package ru.pokrovskii.notification.impl

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import ru.pokrovskii.design.R
import ru.pokrovskii.notification.api.NotificationController

internal class NotificationControllerImpl(
    private val context: Context,
) : NotificationController {

    private val notificationManager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun createChannel(
        id: String,
        name: String,
    ): NotificationChannel {
        return NotificationChannel(
            /* id = */ id,
            /* name = */ name,
            /* importance = */ NotificationManager.IMPORTANCE_DEFAULT,
        ).apply {
            notificationManager.createNotificationChannel(this)
        }
    }

    override fun showNotification(
        title: String,
        message: String,
        notificationChannelId: String,
    ) {
        val notification = NotificationCompat.Builder(context, notificationChannelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_favorites_filled_24)
            .build()

        notificationManager.notify(ID, notification)
    }

    companion object {

        private const val ID = 1
    }
}