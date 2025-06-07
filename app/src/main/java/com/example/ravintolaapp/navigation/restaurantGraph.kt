package com.example.ravintolaapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.ravintolaapp.presentation.RestaurantsWithAvgRatingsScreen
import com.example.ravintolaapp.presentation.RestaurantViewScreen
import com.example.ravintolaapp.viewmodel.RestaurantsViewModel

fun NavGraphBuilder.restaurantGraph(
    navController: NavHostController,
    viewModel: RestaurantsViewModel
) {
    navigation(startDestination = "restaurants", route = "restaurantFeature") {
        composable("restaurants") {
            RestaurantsWithAvgRatingsScreen(
                state = viewModel.restaurants.collectAsState().value,
                onItemClick = { restaurantId ->
                    navController.navigate("restaurant/$restaurantId")
                }
            )
        }

        composable(
            route = "restaurant/{restaurantId}",
            arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getInt("restaurantId") ?: return@composable
            RestaurantViewScreen(
                restaurantId = restaurantId,
                viewModel = viewModel
            )
        }
    }
}
