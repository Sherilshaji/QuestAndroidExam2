package com.example.exam2

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface NewsDao {
    @Upsert
    fun insert(news:NewsEntity)
}