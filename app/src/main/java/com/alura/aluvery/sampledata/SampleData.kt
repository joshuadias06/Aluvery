package com.alura.aluvery.sampledata

import com.alura.aluvery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(

    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = com.alura.aluvery.R.drawable.burger
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = com.alura.aluvery.R.drawable.pizza
    ),
    Product(
        name = "Batata Frita",
        price = BigDecimal("9.99"),
        image = com.alura.aluvery.R.drawable.fries
    )
)