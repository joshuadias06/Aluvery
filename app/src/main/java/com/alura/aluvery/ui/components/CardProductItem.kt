package com.alura.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alura.aluvery.R
import com.alura.aluvery.extencions.toBrazilianCurrency
import com.alura.aluvery.model.Product
import com.alura.aluvery.sampledata.sampleProducts
import com.alura.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            product.description?.let {
                Text(
                    text = product.description,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Teste",
                    price = BigDecimal(10.00),
                    image = "",
                    description = LoremIpsum(20).values.first()
                )
            )
        }
    }
}
