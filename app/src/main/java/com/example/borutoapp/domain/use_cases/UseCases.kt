package com.example.borutoapp.domain.use_cases

import com.example.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.example.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)