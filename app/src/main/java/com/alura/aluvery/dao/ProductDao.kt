package com.alura.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.alura.aluvery.model.Product
import com.alura.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>(*sampleProducts.toTypedArray())
    }

    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}