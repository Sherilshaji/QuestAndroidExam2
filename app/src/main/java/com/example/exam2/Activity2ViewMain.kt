package com.example.exam2

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity2ViewMain:ComponentActivity(),RecyclerViewAdapter.ItemClickListener {
    private lateinit var source: String
    private lateinit var country: String
    private val viewModel by viewModels<Activity2ViewModel>()
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.recycler_view_main)
        mRecyclerView=findViewById(R.id.recycler_view)
        mRecyclerView.apply {
            layoutManager=LinearLayoutManager(this@Activity2ViewMain,RecyclerView.VERTICAL,false)
            adapter=mAdapter
        }
        val extra= intent.extras
        source= extra?.getString("source").toString()
        country= extra?.getString("country").toString()
        fetchNewsDetails()
        viewModel.newsDetails.observe(this) {
            mAdapter.updateData(it)
        }
    }

    fun fetchNewsDetails(){
        viewModel.getNewsDetails(
            source=source,
            country=country
        )
    }

    override fun onItemClick(view: View?, position: Int) {
        TODO("Not yet implemented")
    }
}