package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    GreetingPreview()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {

        val topBoxColor    = 0xFF000000
        val bottomBoxColor = 0xFF444444
        val buttonColor    = 0xFF465C91

        Column()
        {
            // Just a header
            Box(modifier = Modifier
                .background(Color(buttonColor))
                .height(20.dp)
                .fillMaxWidth()
            ){}


            Box(
                modifier = Modifier
                    .background(Color(topBoxColor)) // Black background
                    .height(200.dp)
                    .fillMaxWidth()
            )
            {

                Text(text = "0", color = Color(0xFFFFFFFF), fontSize = 100.sp)
            }

            Box(
                modifier = Modifier
                    .background(Color(bottomBoxColor)) // Dark grey background
                    .fillMaxSize()
            )
            {
                Column(modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                )
                {
                    // 1st row
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Button(
                            onClick = {}, modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("7")
                        }

                        Button(
                            onClick = {}, modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("8")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                                .weight(1f)
                        ) {
                            Text("9")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("/")
                        }
                    }

                    // 2nd row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("4")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("5")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("6")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("*")
                        }
                    }

                    // 3rd row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("1")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("2")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("3")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("-")
                        }
                    }

                    // 4th row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("0")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("C")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("=")
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .background(Color(buttonColor))
                                .weight(1f)
                        ) {
                            Text("+")
                        }
                    }
                }


            }
        }
    }
}