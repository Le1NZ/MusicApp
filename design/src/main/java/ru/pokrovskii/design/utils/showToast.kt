package ru.pokrovskii.design.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(text: String) {
    Toast.makeText(
        /* context = */ this,
        /* text = */ text,
        /* duration = */ Toast.LENGTH_LONG,
    ).show()
}