package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    GreetingPreview()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {

        val screenColor    = Color(0xFF000000)
        val bottomBoxColor = Color(0xFF444444)
        val primaryColor   = Color(0xFF465C91)

        Column()
        {
            // Just a header
            Box(modifier = Modifier
                .background(primaryColor)
                .height(20.dp)
                .fillMaxWidth()
            ){}


            Box(
                modifier = Modifier
                    .background(screenColor) // Black background
                    .height(200.dp)
                    .fillMaxWidth()
            )
            {

                Text(text = "0", color = Color(0xFFFFFFFF), fontSize = 100.sp)
            }

            TouchPad(
                primaryColor,
                bottomBoxColor
            )
        }
    }
}


enum class DisplayOrder(val index: Int){
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3)
}

@Composable
fun TouchPad(buttonsColor: Color, backgroundColor : Color){
    val buttonsText = arrayOf(
        arrayOf("7", "8", "9", "/"),
        arrayOf("4", "5", "6", "*"),
        arrayOf("1", "2", "3", "-"),
        arrayOf("0", "C", "=", "+")
    )

    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            // matrix[row][col]
            CalculatorRow(buttonsColor,buttonsText[DisplayOrder.FIRST.index])
            CalculatorRow(buttonsColor,buttonsText[DisplayOrder.SECOND.index])
            CalculatorRow(buttonsColor,buttonsText[DisplayOrder.THIRD.index])
            CalculatorRow(buttonsColor,buttonsText[DisplayOrder.FOURTH.index])
        }
    }
}

@Composable
fun ColumnScope.CalculatorRow(buttonsColor: Color, texts: Array<String>){
    Row(modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        CalculatorButton(buttonsColor, texts[DisplayOrder.FIRST.index])
        CalculatorButton(buttonsColor, texts[DisplayOrder.SECOND.index])
        CalculatorButton(buttonsColor, texts[DisplayOrder.THIRD.index])
        CalculatorButton(buttonsColor, texts[DisplayOrder.FOURTH.index])
    }
}


@Composable
fun RowScope.CalculatorButton(
    buttonColor: Color,
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        )
    ) {
        Text(text = text, fontSize = 50.sp)
    }
}
