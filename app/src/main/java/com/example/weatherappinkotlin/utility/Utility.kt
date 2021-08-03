package com.example.weatherappinkotlin.utility

import com.example.weatherappinkotlin.R
import android.app.ProgressDialog
import android.content.Context

object Utility {
    var CURRENT_TEMPERATURE = ""
    var progressDialog: ProgressDialog? = null
    fun showProgress(context: Context?) {
        try {
            if (context != null) {
                if (progressDialog != null && progressDialog!!.isShowing()) {
                    return
                }
                progressDialog =
                    ProgressDialog.show(context, null, null)
                progressDialog!!.getWindow()!!.setBackgroundDrawableResource(
                        android.R.color.transparent
                    )
                progressDialog!!.setContentView(R.layout.progress_bar)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideProgress() {
        try {
            if (progressDialog != null && progressDialog!!.isShowing()) {
                progressDialog!!.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}