package cn.xdwanj.data.service

import cn.xdwanj.data.entity.ResolveResult
import kotlinx.coroutines.channels.Channel

interface IResolveService {
  suspend fun listResolve(urlList: List<String>, resultChannel: Channel<String>)
}