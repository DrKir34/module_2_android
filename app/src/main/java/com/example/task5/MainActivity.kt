package com.example.task5

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.task5.ui.theme.Task5Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.tooling.preview.devices.WearDevice
import androidx.wear.tooling.preview.devices.WearDevices
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task4(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {

    val displayName = if (name != null) {
        "Hi, $name"
    } else {
        "Имя не задано"
    }
    Text(
        text = displayName,
        modifier = modifier
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/*@SuppressLint("UnrememberedMutableState")
@Composable
fun ShowUI() {
    Log.d("RRR", "Recompose")
    var counter by mutableStateOf(0)
    Box(

    )
}*/

@Preview(
    showBackground = true
)
@Composable
fun HelloPreview1() {
    Task5Theme {
        Text(
            text = "Hello, Preview"
        )
    }
}

@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape",
)
@Composable
fun HelloPreview2() {
    Task5Theme {
        Text(
            text = "Hello, Preview"
        )
    }
}


@Preview(showBackground = true,
    backgroundColor = 0xFF000000,
    device = "spec: width=240dp, height=240dp,dpi=320,isRound=true",
    name = "round_yellow_circle")
@Composable
fun HelloPreview3() {
    Task5Theme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hello, Preview",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true, name="Task 3.1")
@Composable
fun Task3(modifier: Modifier = Modifier) {
    val str = stringResource(id = R.string.jetpack)
    Task5Theme {
        Column(modifier.padding(15.dp)) {
            Text(
                text = str,
                color = Color.Green,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )

            Text(
                text = stringResource(id = R.string.jetpack),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = stringResource(id = R.string.jetpack),
                fontSize = 24.sp,
                color = Color.Black,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(top = 48.dp)
                    .background(Color.Green)
            )
        }
    }
}

@Composable
fun Task4(modifier: Modifier = Modifier) {
    var value by remember{mutableStateOf(0)}
    androidx.compose.material3.Button(
        onClick = {},
        modifier = modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Нажми на меня",
            textAlign = TextAlign.Center
        )
        }
}

@Composable
fun Task5(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxHeight().padding(vertical = 16.dp).aspectRatio(1f),
            shape = CircleShape,
            color = Color.Red
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "АБ",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task5Theme {
        Greeting("Android")
    }
}