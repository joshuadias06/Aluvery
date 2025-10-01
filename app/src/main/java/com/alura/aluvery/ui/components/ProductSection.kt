package com.alura.aluvery.ui.components

import androidx.compose.foundation.R
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alura.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection(){
    Column{
        Text(
            text = "Promoções",
            Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Spacer(Modifier)
            ProductItem(
                Product(
                    name = "Hamburguer",
                    price = BigDecimal("12.99"),
                    image = com.alura.aluvery.R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    name = "Pizza",
                    price = BigDecimal("19.99"),
                    image = com.alura.aluvery.R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    name = "Batata Frita",
                    price = BigDecimal("9.99"),
                    image = com.alura.aluvery.R.drawable.fries
                )
            )
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSectionPreview(){
    ProductSection()
}