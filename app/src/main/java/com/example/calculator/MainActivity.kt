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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                GreetingPreview()
            }
        }
    }
}

enum class DisplayOrder(val index: Int){
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3)
}

data class ButtonStyles(
    val color: Color,
    val shape: Shape,
    val fontSize: TextUnit
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val screenColor        = Color(0xFF000000)
    val touchPadBackground = Color(0xFF444444)
    val primaryColor       = Color(0xFF465C91)


    val buttonStyles = ButtonStyles(
        primaryColor,
        RoundedCornerShape(50.dp),
        50.sp
    )

    Column(modifier = Modifier
        .background(primaryColor)
        .padding(top = 35.dp)
    ){

        Screen(screenColor)

        TouchPad(
            buttonStyles,
            touchPadBackground
        )
    }
}

@Composable
fun Screen(screenColor : Color){
    Box(
        modifier = Modifier
            .background(screenColor)
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ){
        Text(
            text = "0",
            color = Color(0xFFFFFFFF),
            fontSize = 70.sp
        )
    }
}

@Composable
fun TouchPad(buttonsStyles: ButtonStyles, backgroundColor : Color){
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
            CalculatorRow(buttonsStyles,buttonsText[DisplayOrder.FIRST.index])
            CalculatorRow(buttonsStyles,buttonsText[DisplayOrder.SECOND.index])
            CalculatorRow(buttonsStyles,buttonsText[DisplayOrder.THIRD.index])
            CalculatorRow(buttonsStyles,buttonsText[DisplayOrder.FOURTH.index])
        }
    }
}

@Composable
fun ColumnScope.CalculatorRow(buttonsStyles: ButtonStyles, texts: Array<String>){
    Row(modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        CalculatorButton(buttonsStyles, texts[DisplayOrder.FIRST.index])
        CalculatorButton(buttonsStyles, texts[DisplayOrder.SECOND.index])
        CalculatorButton(buttonsStyles, texts[DisplayOrder.THIRD.index])
        CalculatorButton(buttonsStyles, texts[DisplayOrder.FOURTH.index])
    }
}


@Composable
fun RowScope.CalculatorButton(
    buttonStyle: ButtonStyles,
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
        shape = buttonStyle.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonStyle.color
        )
    ) {
        Text(
            text = text,
            fontSize = buttonStyle.fontSize
        )
    }
}
