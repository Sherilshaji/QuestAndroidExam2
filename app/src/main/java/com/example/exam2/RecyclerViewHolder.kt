package com.example.exam2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView: View,mClickListener: RecyclerViewAdapter.ItemClickListener): RecyclerView.ViewHolder(itemView) {
    var textViewTitle: TextView = itemView.findViewById(R.id.title)
    var textViewDescription: TextView = itemView.findViewById(R.id.description)
    var textViewSource: TextView = itemView.findViewById(R.id.source)
    init {
        itemView.setOnClickListener { view ->
            mClickListener.onItemClick(view, adapterPosition)
        }
    }
}