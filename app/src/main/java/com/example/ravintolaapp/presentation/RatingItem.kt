package com.example.ravintolaapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ravintolaapp.presentation.RatingBar
import com.example.ravintolaapp.data.dto.RatingDto

@Composable
fun RatingItem(item: RatingDto, onRemove: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                RatingBar(rating = item.rating)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { onRemove(item.id) }) {
                    Icon(Icons.Filled.Delete, contentDescription = "delete review")
                }
            }
            Text(item.message ?: "")
        }
    }
}
