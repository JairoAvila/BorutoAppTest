package com.example.borutoapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.withTransaction
import com.example.borutoapp.data.local.BorutoDatabase
import com.example.borutoapp.data.remote.BorutoApi
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.util.extractPageNumber
import java.lang.Exception

class SearchHeroesSource(
    private val borutoApi: BorutoApi,
    private val query: String,
    private val borutoDatabase: BorutoDatabase
) : PagingSource<Int, Hero>() {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = borutoApi.searchHeroes(name = query)
            val heroes = apiResponse.results
            borutoDatabase.withTransaction { heroDao.addHeroes(heroes) }
            LoadResult.Page(
                data = heroes.ifEmpty { emptyList() },
                prevKey = null,
                nextKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}