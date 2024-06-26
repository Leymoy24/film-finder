package com.example.filmfinder.ui.screen.allmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.filmfinder.data.model.MovieModel
import com.example.filmfinder.data.room.entity.QueryEntity
import com.example.filmfinder.domain.DeleteFirstQueryUseCase
import com.example.filmfinder.domain.GetMoviesPageUseCase
import com.example.filmfinder.domain.GetMoviesUseCase
import com.example.filmfinder.domain.GetQueriesCountUseCase
import com.example.filmfinder.domain.GetQueriesUseCase
import com.example.filmfinder.domain.SearchMoviesPageUseCase
import com.example.filmfinder.domain.SetCurrentMovieUseCase
import com.example.filmfinder.domain.SetQueryUseCase
import com.example.filmfinder.domain.ShiftIdsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class AllMoviesViewModel @Inject constructor(
    private val getMovies: GetMoviesUseCase,
    private val getMoviesPage: GetMoviesPageUseCase,
    private val setCurrentMovie: SetCurrentMovieUseCase,
    private val searchMoviesPage: SearchMoviesPageUseCase,
    private val getQueries: GetQueriesUseCase,
    private val setQuery: SetQueryUseCase,
    private val deleteFirstQuery: DeleteFirstQueryUseCase,
    private val getQueriesCount: GetQueriesCountUseCase,
    private val shiftIds: ShiftIdsUseCase
) : ViewModel() {

    init { loadQueries() }

    private val _search = MutableStateFlow("")

    val search = _search.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = "",
        )

    private val _isSearchShowing = MutableStateFlow(false)

    val isSearchShowing = _isSearchShowing.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = false,
        )

    val searchedMovies = search.debounce(1000.milliseconds).flatMapLatest { query ->
        searchMoviesPage(query = query)
    }.cachedIn(viewModelScope)

    fun getMovies() = getMoviesPage()
        .cachedIn(viewModelScope)

    fun performSetCurrentMovie(movie: MovieModel?) {
        setCurrentMovie(movie = movie)
    }

    fun setSearch(query: String) {
        _search.value = query
    }

    fun toggleIsSearchShowing() {
        _isSearchShowing.value = !_isSearchShowing.value
    }

    private val _queries = MutableStateFlow<List<QueryEntity>>(emptyList())

    val queries = _queries.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    fun loadQueries() {
        viewModelScope.launch {
            val queriesList = getQueries()
            _queries.value = queriesList
        }
    }

    fun insertQuery(query: QueryEntity) {
        viewModelScope.launch {
            if (getQueriesCount() >= 20) {
                deleteFirstQueryDb()
                shiftIdsDb()
            }
            setQuery(query)
            loadQueries()
        }
    }

    fun deleteFirstQueryDb() {
        viewModelScope.launch {
            deleteFirstQuery()
            loadQueries()
        }
    }

    fun shiftIdsDb() {
        viewModelScope.launch {
            shiftIds()
            loadQueries()
        }
    }
}