package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_25.*

class Course_25 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_25)
        title = "拖动条和星级评分条展示"
        // 注册事件监听器
        this.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                this@Course_25.prompt_tv.text = "停止拖动"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                this@Course_25.prompt_tv.text = "开始拖动"
            }
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                this@Course_25.prompt_tv.text = "正在拖动"
                this@Course_25.pb_tv.text = "当前数值:$progress"
            }
        })
    }
}
