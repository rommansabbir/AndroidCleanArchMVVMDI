package com.rommansabbir.androidcleanarchmvvmdi.features.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.GetWeatherRequestDataModel
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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

    private val vm: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter: WeatherReportAdapter

    override fun onCreated(instance: Bundle?) {
        binding.weatherRv.adapter = adapter

        //Create request instance
        GetWeatherRequestDataModel
            .Builder()
            .withLocation("London")
            .withLocation("Seoul")
            .withLocation("Dhaka")
            .withLocation("India")
            //set API key
            .withAPIKey(getString(R.string.weather_api_key)).build().either(
                { handleFailure(it) },
                { requestDataModel ->
                    showHideLoading(true, isCancelable = false)
                    vm.getWeatherReport(requestDataModel,
                        { model ->
                            //Map data to respective model
                            vm.getMapper.invoke(vm.viewModelScope, model) { either ->
                                either.either(
                                    {
                                        showHideLoading(false)
                                        handleFailure(it)
                                    },
                                    {
                                        showHideLoading(false)
                                        adapter.submitDataSource(it)
                                    }
                                )
                            }
                        },
                        {
                            handleFailure(it)
                            showHideLoading(false)
                        })
                }
            )
    }

}