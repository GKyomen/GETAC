package com.ibuild.getac.model

import org.threeten.bp.LocalDate
import java.io.Serializable

data class Reform(
    val reformTitle: String,
    val reformCategory: ReformCategory,
    val products: List<Product>,
    val store: Store,
    val reformDate: LocalDate
) : Serializable {

    val reformTotalValue: Double
        get() = products.sumByDouble { it.prodPrice }
}