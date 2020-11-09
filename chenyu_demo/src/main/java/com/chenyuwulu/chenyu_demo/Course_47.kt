package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class Course_47 : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_47)
        title = "Activity间数据传递方法汇总"

        val w_intent_property_top_webview = findViewById<WebView>(R.id.activity_data_sub_webview)
        w_intent_property_top_webview.settings.javaScriptEnabled = true
        w_intent_property_top_webview.settings.domStorageEnabled = true
        w_intent_property_top_webview.loadUrl("https://mp.weixin.qq.com/s?__biz=MzI1MTAyNzM5Ng==&mid=2649950067&idx=1&sn=90c59fd59b0f28317a3dcdd95521151f&scene=19#wechat_redirect")
    }
}