package com.chenyuwulu.chenyu_demo

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_24.*

class Course_24 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_24)
        title = "进度条展示"

        val mProgressAnimation = this.mypg_img.drawable as AnimationDrawable
        // 启动动画
        this.mypg_img.postDelayed({
            // 启动动画
            mProgressAnimation.start()
        }, 1000)
    }
}
