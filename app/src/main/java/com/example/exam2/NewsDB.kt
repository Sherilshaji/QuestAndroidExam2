package com.example.exam2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDB:RoomDatabase() {
    abstract fun news():NewsDao
}