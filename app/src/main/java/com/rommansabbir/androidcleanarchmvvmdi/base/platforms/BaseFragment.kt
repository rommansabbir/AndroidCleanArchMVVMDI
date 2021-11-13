@file:Suppress("UNCHECKED_CAST")

package com.rommansabbir.androidcleanarchmvvmdi.base.platforms

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.features.auth.AuthActivity


abstract class BaseFragment<V : ViewDataBinding> : Fragment() {

    private var _binding: V? = null
    internal val binding: V
        get() = _binding!!

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    protected open fun handleFailure(failure: Failure) {
        this.activity?.let {
            if (it is BaseActivity<*>) {
                it.handleFailure(failure)
            }
        }
    }

    protected abstract fun onCreated(savedInstance: Bundle?)


    internal fun checkPermissionState(permission: String): Boolean {
        val res = requireContext().checkCallingOrSelfPermission(permission)
        return res == PackageManager.PERMISSION_GRANTED
    }
}