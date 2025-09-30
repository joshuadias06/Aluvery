package com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alura.aluvery.ui.theme.AluveryTheme
import com.alura.aluvery.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AluveryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductItem(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(modifier: Modifier) {
    Column(
        Modifier
            .height(250.dp)
            .width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(brush = Brush.horizontalGradient(colors = listOf(
                    Purple500, Teal200
                )))
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            Modifier
                .size(100.dp)
                .offset(y = (-50).dp)
                .clip(shape = CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        Text(text = "Text 1")
        Text(text = "Text 2")

    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview(){
    ProductItem(modifier = Modifier)
}



