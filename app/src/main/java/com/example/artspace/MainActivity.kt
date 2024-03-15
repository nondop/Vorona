package com.example.artspace

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceScreen() {

    var id by remember { mutableStateOf(1) }
    var image by remember { mutableStateOf(R.drawable.kyiv) }
    var city by remember { mutableStateOf(R.string.ukraine_kyiv) }
    var population by remember { mutableStateOf(R.string.population_kyiv) }

    when (id) {
        1 -> {
            image = R.drawable.kyiv
            city = R.string.ukraine_kyiv
            population = R.string.population_kyiv
        }
        2 -> {
            image = R.drawable.lviv
            city = R.string.ukraine_lviv
            population = R.string.population_lviv
        }
        3 -> {
            image = R.drawable.odesa
            city = R.string.ukraine_odesa
            population = R.string.population_odesa
        }
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ImageAndText(cityImage = image, cityName = city, cityPopulation = population)

        Row  {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray),
                modifier = Modifier
                    .padding(16.dp)
                    .size(120.dp, 40.dp),
                onClick = { if (id>1) id-- }
            ) {
                Text(text = "Previous")
            }
            Button(

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray),
                modifier = Modifier
                    .padding(16.dp)
                    .size(120.dp, 40.dp),

                onClick = { if (id<3) id++ }
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ImageAndText(
@DrawableRes cityImage: Int,
@StringRes cityName: Int,
@StringRes cityPopulation: Int
) {
    Column {
        Image(
            painter = painterResource(id = cityImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(16.dp)
        )
        Column(
            modifier = Modifier
                .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                .align(Alignment.Start)
                .background(Color.LightGray)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = stringResource(cityName),
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif
            )
            Text(
                modifier = Modifier.padding(4.dp),
                text = stringResource(cityPopulation),
                fontStyle = FontStyle.Italic
            )
        }
    }
}

