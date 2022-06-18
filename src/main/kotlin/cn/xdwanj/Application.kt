package cn.xdwanj

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cn.xdwanj.ui.App
import com.google.gson.Gson
import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

const val BASE_URL = "http://159.75.54.27:8200"
val context by lazy { _context }
private lateinit var _context: ApplicationContext

@SpringBootApplication
open class Application {
  @Bean
  open fun gson() = Gson()

  @Bean
  open fun restTemplate(factory: ClientHttpRequestFactory) = RestTemplate(factory)

  @Bean
  open fun clientHttpRequestFactory() = SimpleClientHttpRequestFactory().apply {
    setReadTimeout(5000)
    setConnectTimeout(15000)
  }

  @Bean
  open fun webClient(): WebClient = WebClient.create(BASE_URL)
}

fun main() = application {

  _context = SpringApplication(Application::class.java).apply {
    webApplicationType = WebApplicationType.NONE
  }.run()

  Window(
    onCloseRequest = {
      SpringApplication.exit(context)
      exitApplication()
    },
    title = "netdiskresolve-extension"
  ) {
    App()
  }
}

@Preview
@Composable
fun PreviewApp() {
  App()
}
