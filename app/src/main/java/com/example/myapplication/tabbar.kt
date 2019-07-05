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


class tabbar : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                message.setText(R.string.title_home)
//                tab1()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                message.setText(R.string.title_notifications)
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
            val okHttpClient = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build()
            val call = okHttpClient.newCall(request)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("onFailure位子", "onFailure: ")
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    var x = response
                    Log.d("onResponse位子", "onResponse: " + response.body!!.string())
                }
            })
        }
    }
    fun tab1(){
        message.text = this.getString(R.string.title_home)
    }
}
