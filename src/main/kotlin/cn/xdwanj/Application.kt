package cn.xdwanj

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cn.xdwanj.data.api.ResolveApi
import cn.xdwanj.ui.App
import com.google.gson.Gson
import org.springframework.beans.factory.getBean
import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

const val BASE_URL = "http://159.75.54.27:8200/"
val context by lazy { _context }
private lateinit var _context: ApplicationContext

@SpringBootApplication
class Application {
  @Bean
  fun gson() = Gson()

  @Bean
  fun restTemplate(factory: ClientHttpRequestFactory) = RestTemplate(factory)

  @Bean
  fun clientHttpRequestFactory() = SimpleClientHttpRequestFactory().apply {
    setReadTimeout(5000)
    setConnectTimeout(15000)
  }
}

fun main() = application {

  _context = SpringApplication(Application::class.java).apply {
    webApplicationType = WebApplicationType.NONE
  }.run()

  val bean = context.getBean<ResolveApi>()

  Window(onCloseRequest = ::exitApplication) {
    App()
  }
}

@Preview
@Composable
fun PreviewApp() {
  App()
}
