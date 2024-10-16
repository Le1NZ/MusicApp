package ru.pokrovskii.navigation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.R
import ru.pokrovskii.navigation.router.resolveFragment

internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, Screen.Search.resolveFragment())
            .commit()
    }
}
