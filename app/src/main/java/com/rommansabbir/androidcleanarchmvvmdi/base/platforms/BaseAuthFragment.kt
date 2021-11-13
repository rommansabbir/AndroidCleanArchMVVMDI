package com.rommansabbir.androidcleanarchmvvmdi.base.platforms

import android.util.Log
import androidx.databinding.ViewDataBinding
import com.rommansabbir.androidcleanarchmvvmdi.features.auth.AuthActivity

abstract class BaseAuthFragment<V : ViewDataBinding> : BaseFragment<V>() {
    /**
     * Check if the current parent activity is [AuthActivity] or not.
     * If [AuthActivity] return via callback else log the event.
     *
     * @param onActivity, Callback to get [AuthActivity]
     */
    internal fun asAuthActivity(onActivity: (activity: AuthActivity) -> Unit) {
        this.activity?.let {
            if (it is AuthActivity) {
                onActivity.invoke(it)
            } else {
                Log.d(this::class.java.name, "Activity not matched")
            }
        }
    }
}