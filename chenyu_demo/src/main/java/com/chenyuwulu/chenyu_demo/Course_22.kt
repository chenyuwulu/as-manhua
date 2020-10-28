package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_22.*

class Course_22 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_22)
        title = "图片轮播展示"

        val mImageIds = intArrayOf(
            R.drawable.bh3_1,
            R.drawable.bh3_2,
            R.drawable.bh3_3,
            R.drawable.bh3_4,
            R.drawable.bh3_5,
            R.drawable.bh3_6,
            R.drawable.bh3_7,
            R.drawable.bh3_8,
            R.drawable.bh3_9
        )
        val adapter = Course_22_MyFilpperAdapter(this, mImageIds)
        this.flipper.adapter = adapter
        this.prev_btn.setOnClickListener{
            this.flipper.showPrevious()// 显示上一个组件
            this.flipper.stopFlipping()// 停止自动播放
        }
        this.next_btn.setOnClickListener{
            this.flipper.showNext()// 显示下一个组件。
            this.flipper.stopFlipping()// 停止自动播放
        }
        this.auto_btn.setOnClickListener{
            this.flipper.startFlipping()// 开始自动播放
        }
    }
}
