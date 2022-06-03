package cn.xdwanj.data.entity

import org.springframework.stereotype.Component

data class ResolveResult(
    val code: Int,
    val durl: String,
    val fileid: String,
    val filename: String,
    val filesize: String,
    val message: String
)