package com.example.filmfinder.ui.screen.filters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmfinder.data.model.FieldModel
import com.example.filmfinder.data.network.ApiResult
import com.example.filmfinder.domain.GetCountriesUseCase
import com.example.filmfinder.domain.GetFiltersUseCase
import com.example.filmfinder.domain.GetGenresUseCase
import com.example.filmfinder.domain.SetFiltersUseCase
import com.example.filmfinder.ui.util.ScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FiltersViewModel(
    private val getGenres: GetGenresUseCase,
    private val getCountries: GetCountriesUseCase,
    private val setFilters: SetFiltersUseCase,
    private val getFilters: GetFiltersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ScreenUiState>(ScreenUiState.Initial)
    val uiState: StateFlow<ScreenUiState> = _uiState

    private val _genres = MutableStateFlow<List<FieldModel>>(listOf())
    val genres: StateFlow<List<FieldModel>> = _genres

    private val _countries = MutableStateFlow<List<FieldModel>>(listOf())
    val countries: StateFlow<List<FieldModel>> = _countries

    init {
        performGetGenres()
        performGetCountries()
    }

    private fun performGetGenres(){
        viewModelScope.launch {
            _uiState.value = ScreenUiState.Loading

            when (val result = getGenres()) {
                is ApiResult.Success -> {
                    _genres.value = result.data
                    _uiState.value = ScreenUiState.Success(result.data)
                }

                is ApiResult.Error -> {
                    _uiState.value = ScreenUiState.Error(result.error)
                }
            }
        }
    }

    private fun performGetCountries(){
        viewModelScope.launch {
            _uiState.value = ScreenUiState.Loading

            when (val result = getCountries()) {
                is ApiResult.Success -> {
                    _countries.value = result.data
                    _uiState.value = ScreenUiState.Success(result.data)
                }

                is ApiResult.Error -> {
                    _uiState.value = ScreenUiState.Error(result.error)
                }
            }
        }
    }

    fun applyFilters(listOfFilters: List<String?>){
        setFilters(listOfFilters = listOfFilters)
    }

    fun performGetFilters(): List<String?> {
        return getFilters()
    }
}