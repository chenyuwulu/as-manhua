package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class Course_42 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_42)
        title = "SwipeRefreshLayout下拉刷新"
        val mSwipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.container_swipe)
        val mContentTv = findViewById<TextView>(R.id.content_tv)
        mSwipeRefreshLayout.setColorSchemeResources(
            android.R.color.holo_blue_light,
            android.R.color.holo_red_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_green_light
        )
        mSwipeRefreshLayout.setOnRefreshListener {
            mContentTv.text = "正在刷新，请稍后。。。"
            Handler().run {
                mContentTv.text = "刷新完毕！"
                mSwipeRefreshLayout.isRefreshing = false
            }
        }
    }
}