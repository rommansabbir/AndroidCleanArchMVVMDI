package com.rommansabbir.androidcleanarchmvvmdi.features.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    object Factory {
        fun startActivity(
            context: Activity,
            shouldFinish: Boolean,
            payload: Bundle?
        ) {
            context.startActivity(
                Intent(context, HomeActivity::class.java).apply {
                    payload?.let { putExtra("payload", it) }
                })
            if (shouldFinish) {
                context.finish()
            }
        }
    }

    override val layoutRes: Int
        get() = R.layout.activity_home

    override fun onCreated(instance: Bundle?) {

    }
}