package com.example.fitlog.di

import android.content.Context
import com.example.fitlog.data.repository.ExercisesRepositoryImpl
import com.example.fitlog.domain.repository.ExercisesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideExercisesRepository(
        @ApplicationContext context: Context
    ): ExercisesRepository {
        return ExercisesRepositoryImpl(context)
    }
}
