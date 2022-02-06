package com.example.mvvm_hilt.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_hilt.data.TodoDatabase
import com.example.mvvm_hilt.data.TodoRepository
import com.example.mvvm_hilt.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesTodoDatabase(app:Application) : TodoDatabase {
     return  Room.databaseBuilder(
         app,
         TodoDatabase::class.java,
         "todo_db"
     ).build()
    }


    @Provides
    @Singleton

    fun provideTodoRepository(db: TodoDatabase) : TodoRepository{
        return TodoRepositoryImpl(db.dao)
    }

}