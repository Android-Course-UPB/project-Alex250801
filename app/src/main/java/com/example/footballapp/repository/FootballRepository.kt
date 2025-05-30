package com.example.footballapp.repository

import android.util.Log
import com.example.footballapp.model.StandingsResponse
import com.example.footballapp.model.TeamStanding
import com.example.footballapp.network.RetrofitInstance
import com.google.gson.Gson
import okhttp3.ResponseBody

class FootballRepository {

    suspend fun getStandings(league: Int, season: Int, team: Int? = null): List<TeamStanding> {
        try {
            val response = RetrofitInstance.api.getStandings(league, season, team)

            if (response.isSuccessful) {
                val rawJson = response.body()?.string()
                Log.d("FootballRepository", "Raw JSON: $rawJson")

                val standingsResponse = Gson().fromJson(rawJson, StandingsResponse::class.java)
                return standingsResponse.response
                    .flatMap { it.league.standings }
                    .flatten()
            } else {
                Log.e("FootballRepository", "API Error ${response.code()}: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.e("FootballRepository", "Exception while fetching standings", e)
        }

        return emptyList()
    }
}
