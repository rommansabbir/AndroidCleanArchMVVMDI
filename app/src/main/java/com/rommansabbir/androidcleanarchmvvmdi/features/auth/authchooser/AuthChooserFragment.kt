package com.rommansabbir.androidcleanarchmvvmdi.features.auth.authchooser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rommansabbir.androidcleanarchmvvmdi.R

class AuthChooserFragment : Fragment() {

    companion object {
        fun newInstance() = AuthChooserFragment()
    }

    private lateinit var viewModel: AuthChooserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.auth_chooser_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthChooserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}