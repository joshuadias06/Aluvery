package com.alura.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alura.aluvery.dao.ProductDao
import com.alura.aluvery.model.Product
import com.alura.aluvery.sampledata.sampleCandies
import com.alura.aluvery.sampledata.sampleDrinks
import com.alura.aluvery.sampledata.sampleProducts
import com.alura.aluvery.sampledata.sampleSections
import com.alura.aluvery.stateholders.home.HomeScreenUiState
import com.alura.aluvery.ui.screens.HomeScreen
import com.alura.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(
                onFabClick = {
                    val intent = Intent(this, ProductFormActivity::class.java)
                    startActivity(intent)
                }) {
                val products = dao.products()
                HomeScreen(products = products)
            }
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    AluveryTheme {
        Surface {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = onFabClick) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Adicionar produto"
                        )
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App {
        HomeScreen(
            HomeScreenUiState(
                sections = sampleSections,
                searchedProducts = sampleProducts,
                searchText = "",
                onSearchChange = {})
        )
    }
}
