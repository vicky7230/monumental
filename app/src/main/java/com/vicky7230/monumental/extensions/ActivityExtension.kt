package com.vicky7230.monumental.extensions

import android.app.Activity
import android.view.WindowManager

import androidx.core.view.WindowInsetsControllerCompat


enum class StatusIconColorType {
    Dark, Light
}

fun Activity.setStatusBarAndNavigationBarColor(
    color: Int,
    iconColorType: StatusIconColorType = StatusIconColorType.Light
) {
    this.window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.statusBarColor = color

        val wic = WindowInsetsControllerCompat(this, decorView)
        wic.isAppearanceLightStatusBars = when (iconColorType) {
            StatusIconColorType.Light -> false
            StatusIconColorType.Dark-> true
        } // true or false as desired.

        // And then you can set any background color to the status bar.
        navigationBarColor = color
    }
}