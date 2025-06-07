package com.example.ravintolareviewapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ravintolaapp.presentation.RatingItem
import com.example.ravintolareviewapp.viewmodel.RestaurantViewModel

@Composable
fun RestaurantViewScreen(
    restaurantId: Int,
    viewModel: RestaurantViewModel = hiltViewModel()
) {
    val restaurant by viewModel.restaurant.collectAsState()
    val ratings by viewModel.ratings.collectAsState()

    // load data on screen enter
    LaunchedEffect(restaurantId) {
        viewModel.loadRestaurantAndRatings(restaurantId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = restaurant?.name ?: "Ravintola")
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            restaurant?.let {
                Text(text = "Tyyppi: ${it.type}")
                Text(text = "Hintataso: ${it.priceLevel}")
                Text(text = "Osoite: ${it.address}")
                Spacer(modifier = Modifier.height(12.dp))
            }

            if (ratings.isEmpty()) {
                Text(text = "Ei arvosteluja", style = MaterialTheme.typography.bodyMedium)
            } else {
                ratings.forEach { rating ->
                    RatingItem(
                        item = rating,
                        onRemove = {}
                    )
                }
            }
        }
    }
}