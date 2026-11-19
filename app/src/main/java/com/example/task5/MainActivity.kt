package com.example.task5

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Button
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.task5.ui.theme.Task5Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.tooling.preview.devices.WearDevice
import androidx.wear.tooling.preview.devices.WearDevices
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WaterTracker()
                }
            }
        }
    }
}

// TASK 1 //
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

//TASK 2 //
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

@Preview(showBackground=true, name="Task 4")
@Composable
fun Task4(modifier: Modifier = Modifier) {
    var value by remember{mutableStateOf(0)}
    androidx.compose.material3.Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
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

@Preview(showBackground=true, name="Task 5")
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
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 16.dp)
                .aspectRatio(1f),
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

@Preview(showBackground = true)
@Composable
fun Task6_1(modifier: Modifier = Modifier) {
    val circle = R.drawable.circle
    Box(
        modifier = modifier
            .width(240.dp)
            .height(120.dp)
            .background(Color.Black)
    ) {
        Image(
            modifier = Modifier.align(alignment = Alignment.TopEnd),
            contentScale = ContentScale.Crop,
            painter = painterResource(circle),
            contentDescription = "Imago"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task6_2(modifier: Modifier = Modifier) {
    val circle = R.drawable.circle
    Box(
        modifier = modifier
            .width(240.dp)
            .height(120.dp)
            .background(Color.Blue)
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            painter = painterResource(circle),
            contentScale = ContentScale.FillBounds,
            alpha = 0.5f,
            contentDescription = "Imago"
        )
    }
}

val some_exampe = mapOf<String, String>(
    "Имя" to "Евгений",
    "Отчество" to "Андреевич",
    "Фамилия" to "Лукашин",
    "Мобильный телефон" to "+7 495 495 95 95",
    "Адрес" to "г. Москва, 3-я улица Строителей, д.25, кв.12"
)

val another_exampe = mapOf<String, String>(
    "Имя" to "Василий",
    "Отчество" to "Егорович",
    "Фамилия" to "Кузякин",
    "Мобильный телефон" to "---",
    "Адрес" to "Ивановская область, дер. Крутово, д.4"
)

val third_exampe = mapOf<String, String>(
    "Имя" to "Людмила",
    "Отчество" to "Прокофьевна",
    "Фамилия" to "Калугина",
    "Мобильный телефон" to "+7 495 788 78 78",
    "Адрес" to "Москва, Большая Никитская, д. 43, кв. 290"
)

@Composable
fun Card_Vertical(map: Map<String, String>, modifier: Modifier = Modifier) {
    Box(
            modifier = modifier.background(Color.Gray).fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = map.entries.joinToString(separator="\n") {
                    (key, value) -> "${key}: ${value}"},
                textAlign = TextAlign.Center)
        }
}

@Composable
fun Card_Horizontal(map: Map<String, String>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Gray).fillMaxHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = map.entries.joinToString(separator="\n") {
                (key, value) -> "${key}: ${value}"},
            textAlign = TextAlign.Center)
    }
}

@Preview(showBackground=true)
@Composable
fun Task7_column(modifier: Modifier = Modifier) {
    Column(modifier=modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)){
        Card_Vertical(some_exampe)
        Card_Vertical(another_exampe)
        Card_Vertical(third_exampe)
    }
}

@Preview(showBackground=true)
@Composable
fun Task7_row(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(10.dp)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Card_Horizontal(some_exampe)
        Box(
            modifier = modifier.background(Color.Gray),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = modifier.fillMaxHeight(),
                painter = painterResource(R.drawable.circle),
                contentDescription = "Circle"
            )
        }
    }
}

// TASK 8 //
val primaryColor = Color.Blue
val secondaryColor = Color.Gray
val buttonTextColor = Color.White


@Preview(showBackground = true)
@Composable
fun WaterTracker() {
    var waterCount by rememberSaveable { mutableStateOf(0) }
    var dayCount by rememberSaveable {mutableStateOf(0)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = {
                if (waterCount >= 1500) {
                    dayCount += 1
                } else {
                    dayCount = 0
                }
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Text(
            text = "Дней без обезвоживания: ${dayCount}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )
    }
}