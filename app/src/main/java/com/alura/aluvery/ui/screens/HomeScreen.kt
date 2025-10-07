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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.aluvery.ui.components.CardProductItem
import com.alura.aluvery.ui.components.ProductSection
import com.alura.aluvery.ui.components.SearchTextField
import com.alura.aluvery.ui.states.HomeScreenUiState
import com.alura.aluvery.ui.theme.AluveryTheme
import com.alura.aluvery.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {

    //Stateless

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
    viewModel: HomeScreenViewModel
){
    // Statefull

    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
//            HomeScreen(products = sampleProducts)
        }
    }
}