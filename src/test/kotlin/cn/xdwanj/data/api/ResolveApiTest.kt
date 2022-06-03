package cn.xdwanj.data.api

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest()
class ResolveApiTest {

  @Autowired
  private lateinit var resolveApi: ResolveApi

  @Test
  fun getResult() {
    resolveApi.getResult("https://www.feimaoyun.com/s/k3abz5dl")
  }
}