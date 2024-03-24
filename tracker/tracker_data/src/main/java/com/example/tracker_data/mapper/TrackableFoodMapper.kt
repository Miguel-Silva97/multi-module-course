package com.example.tracker_data.mapper

import com.example.tracker_data.remote.dto.Product
import example.tracker_domain.model.TrackableFood

fun Product.toTrackableFood() =
    TrackableFood(
        name = productName ?: "",
        carbsPer100g = nutriments.carbohydrates100g.toInt(),
        caloriesPer100g = nutriments.energyKcal100g.toInt(),
        proteinPer100g = nutriments.proteins100g.toInt(),
        fatPer100g = nutriments.fat100g.toInt(),
        imageUrl = imageFrontThumbUrl
    )
