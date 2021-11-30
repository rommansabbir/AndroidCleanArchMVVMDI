package com.rommansabbir.androidcleanarchmvvmdi.base.platforms

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.WindowManager
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ContentLoadingDialogBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class LoadingScreen @Inject constructor(@ActivityContext private val context: Context) {
    private var dialog: Dialog = Dialog(context)

    fun show(isCancelable: Boolean) {
        try {
            if (dialog.isShowing) {
                return
            }
            val binding = ContentLoadingDialogBinding.inflate(
                LayoutInflater.from(context),
                null,
                false
            )
            dialog.setContentView(binding.root)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            dialog.setCancelable(isCancelable)
            dialog.setCanceledOnTouchOutside(isCancelable)
            binding.executePendingBindings()
            dialog.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hide() {
        try {
            dialog.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}