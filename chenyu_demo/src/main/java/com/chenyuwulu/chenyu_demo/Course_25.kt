package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_24.*

class Course_25 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_25)
        title = "拖动条和星级评分条展示"
        val mSeekBar = findViewById<SeekBar>(R.id.seekBar)
        val mPromptTv = findViewById<TextView>(R.id.prompt_tv)
        val mProgressTv = findViewById<TextView>(R.id.pb_tv)

        // 注册事件监听器
        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                mPromptTv.text = "停止拖动"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                mPromptTv.text = "开始拖动"
            }

            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mPromptTv.text = "正在拖动"
                mProgressTv.text = "当前数值:" + progress
            }
        })
    }
}
