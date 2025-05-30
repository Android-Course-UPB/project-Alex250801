package com.example.footballapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footballapp.viewmodel.FootballViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandingsScreen(navController: NavController, leagueId: Int, season: Int) {
    val viewModel: FootballViewModel = viewModel()
    val standings by viewModel.standings.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(leagueId, season) {
        viewModel.loadStandings(league = leagueId, season = season)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Standings - $season") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if (error != null) {
                Text("Error: $error", color = MaterialTheme.colorScheme.error)
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(standings) { team ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("${team.rank}", modifier = Modifier.width(30.dp))
                            AsyncImage(
                                model = team.team.logo,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(team.team.name, modifier = Modifier.weight(1f))
                            Text("Pts: ${team.points}", modifier = Modifier.width(60.dp))
                            Text("GD: ${team.goalsDiff}", modifier = Modifier.width(50.dp))
                        }
                    }
                }
            }
        }
    }
}
