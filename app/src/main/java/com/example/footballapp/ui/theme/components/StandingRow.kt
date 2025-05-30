package com.example.footballapp.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballapp.model.TeamStanding

@Composable
fun StandingRow(standing: TeamStanding) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = standing.rank.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.width(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        TeamInfo(team = standing.team)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "${standing.points} pts", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "GD: ${standing.goalsDiff}", style = MaterialTheme.typography.bodySmall)
    }
}
