package com.alura.aluvery.stateholders.home

import com.alura.aluvery.model.Product

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}