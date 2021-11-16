package com.rommansabbir.androidcleanarchmvvmdi.features.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ContentItemWeatherReportBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

@SuppressLint("NotifyDataSetChanged")
class WeatherReportAdapter @Inject constructor(@ActivityContext private val context: Context) :
    RecyclerView.Adapter<WeatherReportViewHolder>() {
    object DataModels {
        class ReportDataModel(val title: String, val description: String)
    }

    private val diffUtilsCallBack =
        object : DiffUtil.ItemCallback<DataModels.ReportDataModel>() {
            override fun areItemsTheSame(
                oldItem: DataModels.ReportDataModel,
                newItem: DataModels.ReportDataModel
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: DataModels.ReportDataModel,
                newItem: DataModels.ReportDataModel
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    private var differ: AsyncListDiffer<DataModels.ReportDataModel> =
        AsyncListDiffer(this, diffUtilsCallBack)


    fun submitDataSource(dataList: MutableList<DataModels.ReportDataModel>) {
        differ.submitList(dataList)
    }

    internal fun collectDataSet(): MutableList<DataModels.ReportDataModel> =
        differ.currentList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherReportViewHolder =
        WeatherReportViewHolder(
            ContentItemWeatherReportBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            ),
            this
        )

    override fun onBindViewHolder(holder: WeatherReportViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int = collectDataSet().size
}

class WeatherReportViewHolder(
    private val binding: ContentItemWeatherReportBinding,
    private val adapter: WeatherReportAdapter
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindView(position: Int) {
        binding.text = "${adapter.collectDataSet()[position].title} : ${adapter.collectDataSet()[position].description}"
        binding.executePendingBindings()
    }
}