package com.dicoding.newsapp.di

import android.content.Context
import com.dicoding.newsapp.data.local.NewRepository
import com.dicoding.newsapp.data.local.room.NewsDatabase
import com.dicoding.newsapp.data.remote.retrofit.ApiConfig
import com.dicoding.newsapp.utils.AppExecutors

object  Injectioon {
    fun providerRepository(context: Context): NewRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewRepository.getInstance(apiService, dao, appExecutors)
    }
}