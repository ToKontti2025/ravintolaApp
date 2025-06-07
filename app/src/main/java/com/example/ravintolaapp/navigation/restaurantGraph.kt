package com.example.ravintolaapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.ravintolaapp.presentation.RestaurantsWithAvgRatingsScreen
import com.example.ravintolareviewapp.presentation.RestaurantViewScreen

fun NavGraphBuilder.restaurantGraph(
    navController: NavHostController
) {
    navigation(startDestination = "restaurants", route = "restaurantFeature") {
        composable("restaurants") {
            RestaurantsWithAvgRatingsScreen(
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
            RestaurantViewScreen(restaurantId = restaurantId)
        }
    }
}
