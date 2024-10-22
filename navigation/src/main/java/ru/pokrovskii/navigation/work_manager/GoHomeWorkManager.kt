package ru.pokrovskii.navigation.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import org.koin.java.KoinJavaComponent.inject
import ru.pokrovskii.navigation.R
import ru.pokrovskii.notification.api.NotificationController

internal class GoHomeWorkManager(
    private val context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    private val notificationController by inject<NotificationController>(NotificationController::class.java)

    override fun doWork(): Result {
        val channel = notificationController.createChannel(
            id = NOTIFICATION_CHANNEL_ID,
            name = context.getString(R.string.work_manager_notification_channel)
        )
        notificationController.showNotification(
            title = context.getString(R.string.work_manager_notification_title),
            message = context.getString(R.string.work_manager_notification_subtitle),
            notificationChannelId = channel.id,
        )

        return Result.success()
    }

    companion object {

        private const val NOTIFICATION_CHANNEL_ID = "work_manager_channel_id"
    }
}