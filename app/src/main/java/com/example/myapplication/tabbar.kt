package com.example.myapplication

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.tabbar.*
import okhttp3.*
import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.FormBody
import com.google.gson.Gson








class tabbar : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
//                tab1()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val tabbar_get = findViewById<Button>(R.id.tabbar_get)
        tabbar_get.setOnClickListener {
            val url = "https://weiqing.chenyuwulu.top/app/index.php?i=2&c=entry&do=uni_w&m=chenyu_home"
            var xyz = ""
            //以下是异步GET
//            val okHttpClient = OkHttpClient()
//            val request = Request.Builder()
//                .url(url)
//                .get()//默认就是GET请求，可以不写
//                .build()
//            val call = okHttpClient.newCall(request)
//            call.enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.d("onFailure位子", "onFailure: ")
//                }
//
//                @Throws(IOException::class)
//                override fun onResponse(call: Call, response: Response) {
//                    var x = response
//                    Log.d("onResponse位子", "onResponse: " + response.body!!.string())
//                }
//            })
            //这是同步GET
//            val okHttpClient = OkHttpClient()
//            val request = Request.Builder()
//                .url(url)
//                .build()
//            val call = okHttpClient.newCall(request)
//            Thread(Runnable {
//                try {
//                    val response = call.execute()
//                    Log.d("前面的头", "run: " + response.body!!.string())
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }).start()
            //这是POST提交String
//            val mediaType = "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
//            val requestBody = "name"
//            val request = Request.Builder()
//                .url(url)
//                .post(requestBody.toRequestBody(mediaType))
//                .build()
//            val okHttpClient = OkHttpClient()
//            okHttpClient.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.d("这里是出现错误回调", "onFailure: " + e.message)
//                }
//
//                @Throws(IOException::class)
//                override fun onResponse(call: Call, response: Response) {
//                    Log.d(
//                        "第一个",
//                        response.protocol.toString() + " " + response.code + " " + response.message
//                    )
//                    val headers = response.headers
//                    for (i in 0 until headers.size) {
//                        Log.d("第二个", headers.name(i) + ":" + headers.value(i))
//                    }
//                    Log.d("第三个", "onResponse: " + response.body!!.string())
//                }
//            })
            //这是POST提交流
//            val requestBody = object : RequestBody() {
//                @Nullable
//                override fun contentType(): MediaType? {
//                    return "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
//                }
//
//                @Throws(IOException::class)
//                override fun writeTo(sink: BufferedSink) {
//                    sink.writeUtf8("I am Jdqm.")
//                }
//            }
//
//            val request = Request.Builder()
//                .url("https://api.github.com/markdown/raw")
//                .post(requestBody)
//                .build()
//            val okHttpClient = OkHttpClient()
//            okHttpClient.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.d("这里是出现错误回调", "onFailure: " + e.message)
//                }
//
//                @Throws(IOException::class)
//                override fun onResponse(call: Call, response: Response) {
//                    Log.d(
//                        "第一个",
//                        response.protocol.toString() + " " + response.code + " " + response.message
//                    )
//                    val headers = response.headers
//                    for (i in 0 until headers.size) {
//                        Log.d("第二个", headers.name(i) + ":" + headers.value(i))
//                    }
//                    Log.d("第三个", "onResponse: " + response.body!!.string())
//                }
//            })
            //POST提交表单
//            val okHttpClient = OkHttpClient()
            val requestBody = FormBody.Builder()
                .add("search", "Jurassic Park")
                .build()
            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()
//            okHttpClient.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.d("失败的回复", "onFailure: " + e.message)
//                }
//
//                @Throws(IOException::class)
//                override fun onResponse(call: Call, response: Response) {
//                    Log.d(
//                        "第一个",
//                        response.protocol.toString() + " " + response.code + " " + response.message
//                    )
//                    val headers = response.headers
//                    for (i in 0 until headers.size) {
//                        Log.d("第二个", headers.name(i) + ":" + headers.value(i))
//                    }
//                    xyz = response.body!!.string()
//                    Log.d("第三个", "onResponse: " + xyz)
//                }
//            })
            val HttpUtil = request()
            HttpUtil.sendRequestWithOkhttp(request, object:Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("失败的回复", "onFailure: " + e.message)
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    Log.d(
                        "第一个",
                        response.protocol.toString() + " " + response.code + " " + response.message
                    )
                    val headers = response.headers
                    for (i in 0 until headers.size) {
                        Log.d("第二个", headers.name(i) + ":" + headers.value(i))
                    }
                    xyz = response.body!!.string()
                    Log.d("第三个", "onResponse: " + xyz)
                }
            })
        }
    }
    fun tab1(){
        message.text = this.getString(R.string.title_home)
    }
}
