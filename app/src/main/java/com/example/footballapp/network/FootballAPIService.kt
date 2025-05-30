package com.example.footballapp.network

import com.example.footballapp.model.StandingsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.Response
import okhttp3.ResponseBody

interface FootballApiService {

    @Headers(
        "X-RapidAPI-Key: ${com.example.footballapp.util.Constants.API_KEY}",
        "X-RapidAPI-Host: ${com.example.footballapp.util.Constants.API_HOST}"
    )

    @GET("standings")
    suspend fun getStandings(
        @Query("league") leagueId: Int,
        @Query("season") season: Int,
        @Query("team") teamID: Int? = null
    ): Response<ResponseBody>
}
