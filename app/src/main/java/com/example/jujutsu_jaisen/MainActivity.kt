package com.example.jujutsu_jaisen

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jujutsu_jaisen.ui.theme.JUJUTSU_JAISENTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JUJUTSU_JAISENTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    pictureLayout()
                }
            }
        }
    }
}
@Composable
fun pictureLayout()
{
    var result by remember { mutableStateOf(1) }

    val imagesRes = when (result)
    {
        0 -> R.drawable.toji
        1 -> R.drawable.sataru
        2 -> R.drawable.yuta
        else -> R.drawable.sukuna
    }
    val Title = when(result)
    {
        0 -> "The Sorcerer Killer"
        1 -> "The strongest jujutsu sorcerer in the world"
        2 -> "Special grade sorcerer"
        else -> "The King of Curses"
    }
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                shape = RectangleShape) {

                Image(painter = painterResource(id = imagesRes),
                    contentDescription ="Images of anime Characters from jujutsu Kaisen",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.padding(16.dp))
            }

            pictureDiscriptor(title = Title, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
            val maxValue = 2
            DisplayControllerButtons(onTapPrevious = {
                result--
                if (result == -1)
                {
                    result = maxValue
                }
                                                     },
                onTapNext = {
                    result++
                    if (result == maxValue +1)
                    {
                        result
                    }
                })


                
        }
    }

}

@Composable
fun pictureDiscriptor(title: String,
                      modifier: Modifier = Modifier)
{
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Text(text = "The Anime JJK\"JUJUTSU KAISEN\" Requires a lookout", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun DisplayControllerButtons(
    onTapPrevious : () -> Unit,
    onTapNext : () -> Unit,
    modifier: Modifier = Modifier

)
{
    Row (verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier){
            Button(onTapPrevious) {
                Text(text = "Previous")
            }
        Spacer(modifier = Modifier.width(32.dp))
            Button(onTapNext) {
                Text(text = "Next")
            }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JUJUTSU_JAISENTheme {
        pictureLayout()
    }
}