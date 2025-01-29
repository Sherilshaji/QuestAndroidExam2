package com.example.exam2

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class RecyclerViewMain:ComponentActivity(),RecyclerViewAdapter.ItemClickListener {
    private lateinit var source: String
    private lateinit var country: String
    private val viewModel by viewModels<RecyclerActivityViewModel>()
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)
    private lateinit var newsDB:NewsDB
    private lateinit var dao: NewsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.recycler_view_main)
        mRecyclerView=findViewById(R.id.recycler_view)
        mRecyclerView.apply {
            layoutManager=LinearLayoutManager(this@RecyclerViewMain,RecyclerView.VERTICAL,false)
            adapter=mAdapter
        }
        val extra= intent.extras
        source= extra?.getString("source").toString()
        country= extra?.getString("country").toString()
        fetchNewsDetails()
        viewModel.newsDetails.observe(this) {
            mAdapter.updateData(it)
        }
        //newsDB=Room.databaseBuilder(this,NewsDB::class.java,"news-db").build()
        //dao=newsDB.news()
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