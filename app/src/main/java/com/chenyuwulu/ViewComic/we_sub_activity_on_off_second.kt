package com.chenyuwulu.ViewComic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button


@SuppressLint("Registered")
class we_sub_activity_on_off_second : AppCompatActivity() {
    object ojbk {
        val ACA = "message"
        val we_sub = "string"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.we_sub_activity_on_off_second)

        // 获取应用程序中的返回按钮
        val backBtn = findViewById<View>(R.id.back_btn) as Button
        // 获取应用程序中的返回关闭按钮
        val backCloseBtn = findViewById<View>(R.id.back_close_btn) as Button
        // 获取应用程序中的关闭按钮
        val closeBtn = findViewById<View>(R.id.close_btn) as Button

        // 为返回按钮绑定事件监听器
        backBtn.setOnClickListener {
            // 获取启动当前Activity的上一个Intent
            val intent = Intent(this@we_sub_activity_on_off_second, we_sub::class.java)
            intent.putExtra(ojbk.we_sub,"activity_on_off")
            // 启动intent对应的Activity
            startActivity(intent)
        }
        // 为返回关闭按钮绑定事件监听器
        backCloseBtn.setOnClickListener {
            // 获取启动当前Activity的上一个Intent
            val intent = Intent(this@we_sub_activity_on_off_second, we_sub::class.java)
            intent.putExtra(ojbk.we_sub,"activity_on_off")
            // 启动intent对应的Activity
            startActivity(intent)
            // 结束当前Activity
            finish()
        }
        // 为关闭按钮绑定事件监听器
        closeBtn.setOnClickListener {
            // 结束当前Activity
            finish()
        }
    }
}