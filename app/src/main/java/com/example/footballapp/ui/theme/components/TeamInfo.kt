package com.example.footballapp.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.footballapp.model.Team

@Composable
fun TeamInfo(team: Team) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(team.logo),
            contentDescription = "${team.name} logo",
            modifier = Modifier.size(48.dp)
        )
        Text(text = team.name, style = MaterialTheme.typography.bodySmall)
    }
}
