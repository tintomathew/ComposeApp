package com.example.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class UtilModule {
    @Provides
    @Reusable
    fun bindStringResource(@ApplicationContext context: Context): StringResource =
        StringResourceImpl(context)
}

@Qualifier
annotation class ForApplication