package com.ibuild.getac.model

import java.io.Serializable

data class Product (
    val prodName: String,
    val prodPrice: Double,
    val prodQty: Int = 1,
    val prodUnit: String,
    val prodStoreName: String,
    val prodStoreRating: Double
) : Serializable