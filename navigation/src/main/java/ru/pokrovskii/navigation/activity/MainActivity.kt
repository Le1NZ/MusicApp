package ru.pokrovskii.navigation.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import ru.pokrovskii.navigation.R
import ru.pokrovskii.navigation.work_manager.GoHomeWorkManagerFactory

internal class MainActivity : AppCompatActivity() {

    private val workManager by lazy {
        GoHomeWorkManagerFactory.createGoHomeWorkManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        requestNotificationPermissionIfNeeded()
    }

    override fun onStop() {
        performWorkManager()
        super.onStop()
    }

    private fun requestNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    /* context = */ this,
                    /* permission = */ Manifest.permission.POST_NOTIFICATIONS,
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermission()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            /* activity = */ this,
            /* permissions = */ arrayOf(Manifest.permission.POST_NOTIFICATIONS),
            /* requestCode = */ 0,
        )
    }

    private fun performWorkManager() {
        val workRequest = GoHomeWorkManagerFactory.createWorkRequest()
        workManager.enqueue(workRequest)
    }
}
