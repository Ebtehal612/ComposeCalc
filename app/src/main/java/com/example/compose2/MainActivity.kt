package com.example.compose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose2.ui.theme.Compose2Theme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
            ) {
                val showDialog = remember { mutableStateOf(false) }

                IconButton(onClick = { showDialog.value = true }) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(top = 200.dp, end = 20.dp)
                        .align(Alignment.End)
                ) {
                    Text(text = "5 x 5", fontSize = 20.sp, color = Color.White)
                    Text(
                        text = "25.0\n",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Column(
                    modifier = Modifier
                        .background(Color.DarkGray),
                ) {
                    val row1 = listOf("C", " ", " ", "÷")
                    val row2 = listOf("7", "8", "9", "x")
                    val row3 = listOf("4", "5", "6", "-")
                    val row4 = listOf("1", "2", "3", "+")
                    val row5 = listOf("00", "0", ".", "=")

                    Column(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                            .background(
                                Color.LightGray,
                            )
                            .padding(start = 55.dp, top = 20.dp, bottom = 20.dp, end = 55.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,

                        ) {
                        DisplayList(items = row1, isFirst = true)
                        DisplayList(items = row2)
                        DisplayList(items = row3)
                        DisplayList(items = row4)
                        DisplayList(items = row5)
                    }
                }
                if (showDialog.value) {
                    AlertDialog(
                        title = { Text(text = "Welcome") },
                        text = { Text(text = "Let's Continue") },
                        onDismissRequest = { showDialog.value = false },
                        confirmButton = {
                            Button(
                                onClick = { showDialog.value = false },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                            ) {
                                Text(text = " OK")
                            }
                        })
                }
            }
        }
    }
}


@Composable
fun DisplayList(items: List<String>, isFirst: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEachIndexed { index, item ->
            Text(
                text = item,
                fontWeight = FontWeight.Bold,
                color = if (index == 3) Color.Red else if (isFirst == true && index == 0) Color.Blue else Color.Unspecified
            )
        }
    }
}