package com.example.footballapp.ui.theme.navigation

sealed class Screen(val route: String) {
    object Selection : Screen("selection")
    object Standings : Screen("standings/{leagueId}/{season}") {
        fun createRoute(leagueId: Int, season: Int) = "standings/$leagueId/$season"
    }
}

