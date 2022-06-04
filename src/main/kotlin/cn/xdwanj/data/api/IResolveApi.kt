package cn.xdwanj.data.api

import cn.xdwanj.data.entity.ResolveResult

interface IResolveApi {
  suspend fun getResult(url: String): ResolveResult
}