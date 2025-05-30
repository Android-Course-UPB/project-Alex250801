package com.example.footballapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.TeamStanding
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FootballViewModel : ViewModel() {

    private val repository = FootballRepository()

    private val _standings = MutableStateFlow<List<TeamStanding>>(emptyList())
    val standings: StateFlow<List<TeamStanding>> = _standings

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading


    private val allowedSeasons = listOf(2021, 2022, 2023)

    fun loadStandings(league: Int, season: Int, team: Int? = null) {
        // Validate the season based on free tier access
        _isLoading.value = true
        if (season !in allowedSeasons) {
            _error.value = "Season $season is not accessible with your API plan."
            _standings.value = emptyList()
            return
        }

        // Launch coroutine for network call
        viewModelScope.launch {
            try {
                Log.d("FootballViewModel", "Fetching standings for league $league, season $season, team $team")
                val data = repository.getStandings(league, season, team)

                if (data.isEmpty()) {
                    _error.value = "No standings found for the selected parameters."
                } else {
                    _error.value = null
                }

                Log.d("FootballViewModel", "Received standings: ${data.size} items")
                _standings.value = data

            } catch (e: Exception) {
                Log.e("FootballViewModel", "Error fetching data", e)
                _standings.value = emptyList()
                _error.value = "Failed to load standings: ${e.localizedMessage ?: "Unknown error"}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
