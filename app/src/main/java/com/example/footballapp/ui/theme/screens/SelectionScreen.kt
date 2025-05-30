// SelectionScreen.kt
package com.example.footballapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footballapp.ui.theme.navigation.Screen

@Composable
fun SelectionScreen(navController: NavController) {
    val leagueMap = mapOf(
        "Premier League (England)" to 39,
        "La Liga (Spain)" to 140,
        "Serie A (Italy)" to 135,
        "Ligue 1 (France)" to 61,
        "Bundesliga (Germany)" to 78
    )
    val seasonList = listOf(2021, 2022, 2023)

    var selectedLeague by remember { mutableStateOf(leagueMap.keys.first()) }
    var selectedSeason by remember { mutableStateOf(seasonList.first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "World Football Standings",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        LeagueDropdown(
            selectedLeague = selectedLeague,
            onLeagueSelected = { selectedLeague = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        SeasonDropdown(
            selectedSeason = selectedSeason,
            onSeasonSelected = { selectedSeason = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            val leagueId = leagueMap[selectedLeague]
            if (leagueId != null) {
                navController.navigate(Screen.Standings.createRoute(leagueId, selectedSeason))
            } else {
                // Optional: show an error Snackbar or Toast
            }
        }) {
            Text("View Standings")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeagueDropdown(selectedLeague: String, onLeagueSelected: (String) -> Unit) {
    val leagues = listOf("Premier League (England)", "La Liga (Spain)", "Serie A (Italy)", "Ligue 1 (France)", "Bundesliga (Germany)")
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedLeague,
            onValueChange = {},
            readOnly = true,
            label = { Text("Choose League") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            leagues.forEach { league ->
                DropdownMenuItem(
                    text = { Text(league) },
                    onClick = {
                        onLeagueSelected(league)
                        expanded = false
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeasonDropdown(selectedSeason: Int, onSeasonSelected: (Int) -> Unit) {
    val seasons = listOf(2021, 2022, 2023)
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedSeason.toString(),
            onValueChange = {},
            readOnly = true,
            label = { Text("Choose Season") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            seasons.forEach { season ->
                DropdownMenuItem(
                    text = { Text(season.toString()) },
                    onClick = {
                        onSeasonSelected(season)
                        expanded = false
                    }
                )
            }
        }
    }
}


