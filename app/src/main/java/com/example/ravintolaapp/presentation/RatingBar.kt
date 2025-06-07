package com.example.ravintolaapp.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.ravintolaapp.R

@Composable
fun RatingBar(modifier: Modifier = Modifier, rating: Float = 0f) {
    val filledStars = rating.toInt()
    val hasHalfStar = (rating - filledStars) >= 0.5f
    val emptyStars = 5 - filledStars - if (hasHalfStar) 1 else 0

    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Full Star",
                tint = Color(0xFFFFD700)
            )
        }
        if (hasHalfStar) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star_half),
                contentDescription = "Half Star",
                tint = Color(0xFFFFD700)
            )
        }
        repeat(emptyStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Empty Star",
                tint = Color.Gray
            )
        }
    }
}
