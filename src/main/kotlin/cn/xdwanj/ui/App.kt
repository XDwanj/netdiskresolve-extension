package cn.xdwanj.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cn.xdwanj.ui.statu.MainViewModel
import cn.xdwanj.ui.statu.resultChannel
import kotlinx.coroutines.cancel

@Preview
@Composable
fun App() {
  MaterialTheme {
    Row {
      Column {
        Box(
          modifier = Modifier
            .background(color = Color.Green)
            .size(60.dp)
        ) {
          Text("logo")
        }
        Column(
          modifier = Modifier
            .background(color = Color.Red)
            .width(60.dp)
            .height(500.dp)
        ) { }
      }
      Spacer(modifier = Modifier.width(20.dp))
      Column {
        Spacer(modifier = Modifier.height(20.dp))

        BigTextField()
        FunctionGroup()

        LogBox()
      }
    }
  }
}

@Composable
fun LogBox() {

  Text("日志栏")
  TextField(
    modifier = Modifier
      .width(700.dp)
      .height(130.dp),
    value = MainViewModel.resultLog,
    onValueChange = { s: String ->
      MainViewModel.resultLog = s
    },
    enabled = true
  )
}

@Composable
fun FunctionGroup() {
  Row {
    Button(
      onClick = {
        MainViewModel.resolve()
      }
    ) {
      Text(text = "解析")
    }
    Spacer(modifier = Modifier.width(10.dp))
    Button(
      onClick = {
        resultChannel.cancel()
        MainViewModel.run {
          resultLog = ""
          cancel()
        }
      }
    ) {
      Text(text = "清空")
    }
  }
}

@Composable
fun BigTextField() {

  Text("输入栏")
  TextField(
    modifier = Modifier
      .background(Color.Cyan)
      .height(300.dp)
      .width(700.dp),
    value = MainViewModel.inputUrl,
    onValueChange = { s: String ->
      MainViewModel.inputUrl = s
    }
  )

}