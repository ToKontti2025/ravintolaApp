package com.example.ravintolaapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ravintolaapp.presentation.components.RestaurantCard
import com.example.ravintolaapp.viewmodel.RestaurantsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantsWithAvgRatingsScreen(
    onItemClick: (Int) -> Unit
) {
    val viewModel: RestaurantsViewModel = hiltViewModel()
    val restaurants by viewModel.restaurants.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("restaurants") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "menu")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(restaurants, key = { it.id }) { restaurant ->
                RestaurantCard(
                    restaurant = restaurant,
                    onClick = { onItemClick(restaurant.id) }
                )
            }
        }
    }
}
