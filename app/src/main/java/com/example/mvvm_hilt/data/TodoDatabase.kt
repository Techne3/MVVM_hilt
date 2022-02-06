package com.example.mvvm_hilt.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Todo::class],
    version = 1,
)

// database Instance
abstract class TodoDatabase : RoomDatabase() {

    abstract val dao:TodoDao

}