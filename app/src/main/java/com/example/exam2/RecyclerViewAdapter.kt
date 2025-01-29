package com.example.exam2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(mainActivity: Activity2ViewMain): RecyclerView.Adapter<RecyclerViewHolder>() {
    private var mClickListener: ItemClickListener = mainActivity

    private var newsModelList = listOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        Log.e("Adapter viewType", viewType.toString())
        val mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false)
        return RecyclerViewHolder(view, mClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        Log.e("Adapter position", position.toString())

        val newsModel = newsModelList[position]
        holder.textViewTitle.text = newsModel.newsTitle
        holder.textViewDescription.text = newsModel.newsDescription
        holder.textViewSource.text=newsModel.source
    }

    override fun getItemCount(): Int {
        return newsModelList.size
    }

    fun updateData(newsModel: List<NewsModel>) {
        newsModelList = newsModel
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}