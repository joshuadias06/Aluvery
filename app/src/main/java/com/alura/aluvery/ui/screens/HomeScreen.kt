package com.alura.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.aluvery.model.Product
import com.alura.aluvery.sampledata.sampleCandies
import com.alura.aluvery.sampledata.sampleDrinks
import com.alura.aluvery.sampledata.sampleProducts
import com.alura.aluvery.stateholders.home.HomeScreenUiState
import com.alura.aluvery.ui.components.CardProductItem
import com.alura.aluvery.ui.components.ProductSection
import com.alura.aluvery.ui.components.SearchTextField
import com.alura.aluvery.ui.theme.AluveryTheme
import kotlin.collections.emptyList

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val sections = state.sections
        val text = state.searchText
        val searchedProducts = state.searchedProducts

        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange,
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductSection(
                            title = title,
                            products = products
                        )
                    }
                }
            }

            items(searchedProducts) { p ->
                CardProductItem(
                    product = p,
                    Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun HomeScreen(
    products: List<Product>
){
    // Statefull

    val sections = mapOf(
        "Todos produtos" to products,
        "Promoçoes" to sampleCandies + sampleDrinks,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )
    var text by remember { mutableStateOf("") }

    fun containsInNameOrDescription() = { product: Product ->
        product.name.contains(text, ignoreCase = true) ||
                product.description?.contains(text, ignoreCase = true)
                ?: false
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    products.filter(containsInNameOrDescription())
        } else emptyList()
    }


    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
    }
    HomeScreen(state = state)
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
//            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}