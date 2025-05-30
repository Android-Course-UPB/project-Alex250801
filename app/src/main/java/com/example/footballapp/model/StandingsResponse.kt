package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class StandingsResponse(
    @SerializedName("response")
    val response: List<LeagueStanding>
)

data class LeagueStanding(
    @SerializedName("league")
    val league: League
)

data class League(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("standings")
    val standings: List<List<TeamStanding>>
)

data class TeamStanding(
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("team")
    val team: Team,
    @SerializedName("points")
    val points: Int,
    @SerializedName("goalsDiff")
    val goalsDiff: Int,
    @SerializedName("group")
    val group: String?,
    @SerializedName("form")
    val form: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("all")
    val all: MatchesStats,
    @SerializedName("home")
    val home: MatchesStats,
    @SerializedName("away")
    val away: MatchesStats,
    @SerializedName("update")
    val update: String
)

data class MatchesStats(
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("goals")
    val goals: Goals
)

data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String
)

data class Goals(
    @SerializedName("for")
    val forGoals: Int,
    @SerializedName("against")
    val againstGoals: Int
)
