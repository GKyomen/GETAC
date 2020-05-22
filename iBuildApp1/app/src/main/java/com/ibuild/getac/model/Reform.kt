package com.ibuild.getac.model

import java.io.Serializable
import java.util.*

data class Reform(
    val reformTitle: String,
    val reformCategory: ReformCategory,
    val products: List<Product>,
    val store: Store,
    val date: Date
) : Serializable {

    val reformTotalValue: Double
        get() = products.sumByDouble { it.prodPrice }
}