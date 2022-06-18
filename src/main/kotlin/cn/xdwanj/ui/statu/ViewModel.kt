package cn.xdwanj.ui.statu

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ViewModel : CoroutineScope by CoroutineScope(Dispatchers.Default)