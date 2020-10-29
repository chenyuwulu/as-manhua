package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_29.*

class Course_29 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_29)
        title = "翻转视图"

        // viewflipper定义在里面，触发方法有问题所以放在外面
        val mViewFlipper = this.details
        this.viewflipper_prev.setOnClickListener {
            mViewFlipper.setInAnimation(this, R.anim.slide_in_right)
            mViewFlipper.setOutAnimation(this, R.anim.slide_out_left)
            // 显示上一个组件
            mViewFlipper.showPrevious()
            // 停止自动播放
            mViewFlipper.stopFlipping()
        }
        this.viewflipper_next.setOnClickListener {
            mViewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
            mViewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
            // 开始自动播放
            mViewFlipper.startFlipping()
        }
        this.viewflipper_auto.setOnClickListener {
            mViewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
            mViewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
            // 显示下一个组件
            mViewFlipper.showNext()
            // 停止自动播放
            mViewFlipper.stopFlipping()
        }
    }
}