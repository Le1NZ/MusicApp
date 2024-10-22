package ru.pokrovskii.navigation.work_manager

import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

internal object GoHomeWorkManagerFactory {

    private const val TAG = "work_manager"
    private const val TIME_TO_WORK_SECS = 10L

    fun createGoHomeWorkManager(context: Context): WorkManager {
        return WorkManager.getInstance(context)
    }

    fun createWorkRequest(): OneTimeWorkRequest {
        return OneTimeWorkRequestBuilder<GoHomeWorkManager>()
            .addTag(TAG)
            .setInitialDelay(TIME_TO_WORK_SECS, TimeUnit.SECONDS)
            .build()
    }
}