package cn.xdwanj.ui

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun App() {
  var text by remember { mutableStateOf("Hello, World!") }

  MaterialTheme {
    Button(onClick = {
      text = "Hello, Desktop!"
    }) {
      Text(text)
    }
    println("hello compose!")
  }
}