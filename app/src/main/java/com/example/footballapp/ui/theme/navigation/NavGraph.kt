package com.example.footballapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.footballapp.ui.theme.screens.SelectionScreen
import com.example.footballapp.ui.theme.screens.StandingsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Selection.route) {
        composable(Screen.Selection.route) {
            SelectionScreen(navController)
        }
        composable(
            route = Screen.Standings.route,
            arguments = listOf(
                navArgument("leagueId") { type = NavType.IntType },
                navArgument("season") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val leagueId = backStackEntry.arguments?.getInt("leagueId") ?: 39
            val season = backStackEntry.arguments?.getInt("season") ?: 2023
            StandingsScreen(navController, leagueId, season)
        }
    }

}


