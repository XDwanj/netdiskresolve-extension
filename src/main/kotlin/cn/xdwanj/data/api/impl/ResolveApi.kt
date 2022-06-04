package cn.xdwanj.data.api.impl

import cn.xdwanj.BASE_URL
import cn.xdwanj.data.api.IResolveApi
import cn.xdwanj.data.entity.ResolveResult
import com.google.gson.Gson
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body

@Component
class ResolveApi(
  val restTemplate: RestTemplate,
  val gson: Gson
) : IResolveApi {
  override suspend fun getResult(url: String): ResolveResult {
    val params = mapOf<String, String>("url" to url)
    return restTemplate.postForObject("$BASE_URL/resolve", params)
  }
}