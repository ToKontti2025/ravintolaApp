package com.example.ravintolaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.ravintolaapp.presentation.RestaurantsWithAvgRatingsScreen
import com.example.ravintolaapp.ui.theme.RavintolaAppTheme
import com.example.ravintolaapp.viewmodel.RestaurantsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: RestaurantsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RavintolaAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    RestaurantsWithAvgRatingsScreen(
                        onItemClick = { restaurantId ->
                            println("clicked restaurant id: $restaurantId")
                        }
                    )
                }
            }
        }
    }
}
