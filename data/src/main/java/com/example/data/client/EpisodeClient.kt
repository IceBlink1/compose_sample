package com.example.data.client

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.BaseApi
import com.example.data.dto.EpisodeDto
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class EpisodeClient @Inject constructor(
    private val api: BaseApi
) : PagingSource<Int, EpisodeDto>() {
    override fun getRefreshKey(state: PagingState<Int, EpisodeDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeDto> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response =
                api.getEpisodeList(page)
            val episodes = response.results
            LoadResult.Page(
                data = episodes,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (response.pageInfo?.next == null) null else page + 1
            )

        } catch (exception: IOException) {
            val error = IOException("Please Check Internet Connection")
            LoadResult.Error(error)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    suspend fun loadById(id: Int): EpisodeDto {
        return api.getEpisodeById(id)
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}