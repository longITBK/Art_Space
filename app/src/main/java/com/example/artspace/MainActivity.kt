package com.example.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
                    color = MaterialTheme.colorScheme.background,
                    shadowElevation = 3.dp
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun SpaceDesign(
    image: Painter,
    title: String,
    artist: String,
    onClick_Next: () -> Unit,
    onClick_Previous: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
) {
        Row() {
                Image(
                    modifier = Modifier
                        .border(BorderStroke(3.dp, Color.Gray), shape = RectangleShape)
                        .padding(20.dp),
                    painter = image,
                    contentDescription = title)

        }
        Spacer(modifier = modifier.height(32.dp))
        Row() {
            Column(
                modifier = Modifier
                    .border(BorderStroke(2.dp, Color.White), shape = RectangleShape)
                    .padding(20.dp),
            ) {
                Text(
                    text = title,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 35.sp
                    )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = artist,
                    fontSize = 16.sp,
                    )
            }
        }
        Spacer(modifier = modifier.height(32.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
//                modifier = Modifier.padding(end = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800080)),
                shape = RoundedCornerShape(8.dp),
                onClick = onClick_Previous
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(128.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800080)),
                shape = RoundedCornerShape(8.dp),
                onClick = onClick_Next
            )
            {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun HandlerSpace(){
    var current_space by remember { mutableStateOf(1) }
    when (current_space){
        1 -> SpaceDesign(
            image = painterResource(id = R.drawable.alberto_gonzalez_vivo_geometria_14128_640x480),
            title = stringResource(R.string.title_1),
            artist = stringResource(R.string.artist_1),
            onClick_Next = { current_space = 2 },
            onClick_Previous = { current_space = 5 })
        2 -> SpaceDesign(
            image = painterResource(id = R.drawable.marianne_hendriks_osmunda_transitum_640x480),
            title = stringResource(R.string.title_2),
            artist = stringResource(R.string.artist_2),
            onClick_Next = { current_space = 3 },
            onClick_Previous = { current_space = 1 })
        3 -> SpaceDesign(
            image = painterResource(id = R.drawable.lia_bekyan_star_sketches_8_untitled_above_the_island_of_hawai_640x480),
            title = stringResource(R.string.title_3),
            artist = stringResource(R.string.artist_3),
            onClick_Next = { current_space = 4 },
            onClick_Previous = { current_space = 2 })
        4 -> SpaceDesign(
            image = painterResource(id = R.drawable.john_folchi_cloudscape_c_640x480),
            title = stringResource(R.string.title_4),
            artist = stringResource(R.string.artist_4),
            onClick_Next = { current_space = 5 },
            onClick_Previous = { current_space = 3 })
        5 -> SpaceDesign(
            image = painterResource(id = R.drawable.christina_mcphee_voice_print_6_atmospheric_river_640x480),
            title = stringResource(R.string.title_5),
            artist = stringResource(R.string.artist_5),
            onClick_Next = { current_space = 1 },
            onClick_Previous = { current_space = 4 })
    }
}
@Composable
fun ArtSpaceApp(){
    HandlerSpace()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            ArtSpaceApp()
        }
    }
}