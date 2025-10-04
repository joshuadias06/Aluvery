package com.alura.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alura.aluvery.sampledata.sampleSections
import com.alura.aluvery.ui.screens.HomeScreen
import com.alura.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    AluveryTheme {
        @Suppress("UnusedMaterial3ScaffoldPaddingParameter")
        Scaffold(modifier = Modifier.fillMaxSize()) {
            HomeScreen(
                sampleSections
            )
        }
    }
}