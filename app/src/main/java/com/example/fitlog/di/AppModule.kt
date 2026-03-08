package com.example.fitlog.di

import android.content.Context
import androidx.room.Room
import com.example.fitlog.data.local.AppDataBase
import com.example.fitlog.data.local.dao.ExerciseDao
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
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideExerciseDao(db: AppDataBase): ExerciseDao {
        return db.exerciseDao()
    }

    @Provides
    @Singleton
    fun provideExercisesRepository(
        @ApplicationContext context: Context,
        dao: ExerciseDao
    ): ExercisesRepository {
        return ExercisesRepositoryImpl(
            context,
            exerciseDao = dao
        )
    }
}
