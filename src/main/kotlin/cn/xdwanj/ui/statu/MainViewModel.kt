package cn.xdwanj.ui.statu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cn.xdwanj.context
import cn.xdwanj.data.entity.ResolveResult
import cn.xdwanj.data.service.impl.ResolveService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import org.springframework.beans.factory.getBean

val resolveService = context.getBean<ResolveService>()
const val remote_address = "http://159.75.54.27:8200/resolve"
lateinit var resultChannel: Channel<String>

object MainViewModel : ViewModel() {
  var resultLog by mutableStateOf("")
  var inputUrl by mutableStateOf("")

  @OptIn(ExperimentalCoroutinesApi::class)
  fun resolve() {
    resultChannel = Channel(1024)
    launch {
      val urlList = inputUrl
        .split("\n")
        .filter { it.isNotBlank() }
      for (url in urlList) {
        println("url=>$url")
      }
      resolveService.listResolve(urlList, resultChannel)
    }
    launch {
      while (resultChannel.isEmpty) {
        val receive = resultChannel.receive()
        println("result=>$receive")
        resultLog += "$receive\n"
      }
    }
  }

  fun destroy() {
    cancel()
  }
}