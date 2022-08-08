package com.example.androidpracticecode.di

import android.content.Context
import com.example.androidpracticecode.utils.SessionManagement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideSessionManagement(@ApplicationContext appContext: Context) =
        SessionManagement(appContext)
}