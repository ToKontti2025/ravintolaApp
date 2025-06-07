package com.example.ravintolaapp.data.dto

data class RatingDto(
    val id: Int,
    val productId: Int,
    val score: Float,
    val comment: String,
    val date: String
)
