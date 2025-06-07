package com.example.ravintolaapp.data.dto

package com.example.ravintolareviewapp.data.dto

data class RatingDto(
    val id: Int,
    val productId: Int,
    val score: Float,
    val comment: String,
    val date: String
)
