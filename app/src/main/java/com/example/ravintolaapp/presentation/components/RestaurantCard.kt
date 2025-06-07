package com.example.ravintolaapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ravintolaapp.data.dto.RestaurantWithAvgRatingDto

@Composable
fun RestaurantCard(
    restaurant: RestaurantWithAvgRatingDto,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = restaurant.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "${restaurant.type} • ${restaurant.priceLevel}")
            Text(text = restaurant.address)
            Text(text = "rating: ${restaurant.avgRating} (${restaurant.reviewCount} reviews)")
        }
    }
}
