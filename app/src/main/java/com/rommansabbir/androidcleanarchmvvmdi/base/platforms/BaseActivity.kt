package com.rommansabbir.androidcleanarchmvvmdi.base.platforms

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.handler.FailureHandler
import javax.inject.Inject


abstract class BaseActivity<V : ViewDataBinding> : AppCompatActivity() {
    private var _binding: V? = null

    internal val binding: V
        get() = _binding!!

    internal lateinit var navController: NavController

    @Inject
    lateinit var failureHandler: FailureHandler

    @Inject
    lateinit var loadingScreen: LoadingScreen

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutRes)
        onCreated(savedInstanceState)
    }

    fun handleFailure(failure: Failure) {
        failureHandler.handleFailure(failure)
    }

    fun hideKeyBoard() {
        val view = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showHideLoading(show: Boolean, isCancelable: Boolean = false) {
        try {
            if (show) {
                loadingScreen.hide()
                loadingScreen.show(isCancelable)
            } else {
                loadingScreen.hide()
            }
        }
        catch (e : Exception){
            e.printStackTrace()
            loadingScreen.hide()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected abstract fun onCreated(instance: Bundle?)
}