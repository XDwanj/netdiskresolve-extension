package cn.xdwanj.data.service.impl

import cn.xdwanj.BASE_URL
import cn.xdwanj.data.entity.ResolveResult
import cn.xdwanj.data.service.IResolveService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

@Service
class ResolveService(
  private val restTemplate: RestTemplate
) : IResolveService {

  override suspend fun listResolve(urlList: List<String>, resultChannel: Channel<String>): Unit =
    withContext(Dispatchers.IO) {
      for (s in urlList) {
        try {
          val durl = restTemplate.postForObject<ResolveResult>("$BASE_URL/resolve", mapOf("url" to s)).durl
          println("durl=>$durl")
          resultChannel.send(durl)
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
      resultChannel.close()
    }
}