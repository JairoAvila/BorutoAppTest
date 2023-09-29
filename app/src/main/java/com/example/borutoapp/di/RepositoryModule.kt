package com.example.borutoapp.di

import com.example.borutoapp.data.repository.Repository
import com.example.borutoapp.domain.use_cases.UseCases
import com.example.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.example.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }

}