package com.example.jetwishlistapp.ui.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetwishlistapp.data.local.Wish

@Composable
fun WishItem(
    wish: Wish,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .height(64.dp)
        ) {
            Text(
                text = wish.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiaryContainer,
                maxLines = 1
            )
            Text(
                text = wish.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                maxLines = 3
            )
        }
    }
}
