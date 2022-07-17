package com.example.themovieapp.di

import com.example.themovieapp.data.remote.network.MovieRemoteDataSource
import com.example.themovieapp.data.remote.network.MovieRemoteDataSourceImpl
import com.example.themovieapp.data.repository.MovieRepository
import com.example.themovieapp.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Singleton
    @Provides
    fun provideMovie(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository = movieRepositoryImpl

    @Singleton
    @Provides
    fun provideRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource = movieRemoteDataSourceImpl
}