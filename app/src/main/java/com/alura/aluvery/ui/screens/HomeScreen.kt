package com.alura.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.aluvery.sampledata.sampleProducts
import com.alura.aluvery.ui.components.ProductSection


@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        Spacer(Modifier)
        ProductSection("Promoções", sampleProducts)
        ProductSection("Doces", sampleProducts)
        ProductSection("Bebidas", sampleProducts)
        Spacer(Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeAppPreview() {
    HomeScreen()
}