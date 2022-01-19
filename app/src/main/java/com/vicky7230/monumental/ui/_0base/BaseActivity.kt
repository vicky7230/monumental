package com.vicky7230.monumental.ui._0base

import android.app.Dialog
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.vicky7230.monumental.R
import com.vicky7230.monumental.utils.CommonUtils
import android.graphics.Typeface

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat


abstract class BaseActivity : AppCompatActivity() {

    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun hasPermissions(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true
        return permissions.none {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    private fun displayMessage(message: String) {
        val snackBar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val font = ResourcesCompat.getFont(this, R.font.manrope_bold)
        snackBar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).typeface =
            font
        snackBar.show()
    }

    private fun displayError(message: String) {
        val snackBar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val font = ResourcesCompat.getFont(this, R.font.manrope_bold)
        snackBar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).typeface =
            font
        snackBar.view.setBackgroundResource(R.drawable.curved_bg_error)
        snackBar.show()
    }

    fun showLoading() {
        hideLoading()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog?.isShowing == true)
                progressDialog?.cancel()
        }
    }

    fun showMessage(message: String?) {
        if (message != null)
            displayMessage(message)
    }

    fun showError(message: String?) {
        if (message != null)
            displayError(message)
    }

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}