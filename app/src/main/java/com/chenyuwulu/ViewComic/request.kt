package com.chenyuwulu.ViewComic

import okhttp3.OkHttpClient
import okhttp3.Request


class request{
    //异步
    fun sendRequestWithOkhttp(request: Request,callback: okhttp3.Callback) {
        val client = OkHttpClient()
//        val request = Request.Builder().url(address).build()
        client.newCall(request).enqueue(callback)
    }
    //同步
    fun sendRequestWithOkhttp_async(address: String): String {
        val client = OkHttpClient()
        val request = Request.Builder().url(address).build()
        val response = client.newCall(request).execute()
        return response.body!!.string()
    }
}