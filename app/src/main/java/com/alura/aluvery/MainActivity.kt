package com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alura.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MyFirstComposable(
                        name = "Composable",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ColumnPreview(){
    Column(){
        Text(text = "Composable 1")
        Text(text = "Composable 2")
    }
}

@Preview
@Composable
fun RowPreview(){
    Row(){
        Text(text = "Composable 1")
        Text(text = "Composable 2")
    }
}

@Preview
@Composable
fun BoxPreview(){
    Box(){
        Text(text = "Composable 1")
        Text(text = "Composable 2")
    }
}

@Composable
fun MyFirstComposable(name: String, modifier: Modifier){
    Text(text = "My First $name")
}
