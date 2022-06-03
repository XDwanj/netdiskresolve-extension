package cn.xdwanj.data.api

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ResolveApi(
  val restTemplate: RestTemplate
) {
  fun getResult(url: String): Map<String, String>? {
    val params = mapOf<String, String>("url" to url)

    return null
  }
}