package com.alura.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.alura.aluvery.ui.screens.ProductFormScreen
import com.alura.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen()
                }
            }
        }
    }
}

