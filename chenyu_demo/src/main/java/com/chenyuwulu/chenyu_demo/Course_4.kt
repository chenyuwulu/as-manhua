package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Course_4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_4)
        title = "单选按钮和复选按钮展示页"
        val mLikeTb = findViewById<ToggleButton>(R.id.like_tb)
        val mBluetoothSwitch = findViewById<Switch>(R.id.switch1)
        mLikeTb.setOnCheckedChangeListener { compoundButton, _ ->
            // 消息提示
            val tb_text = if(compoundButton.isChecked) "喜欢Android开发" else "不喜欢Android开发"
            Toast.makeText(
                this,
                tb_text,
                Toast.LENGTH_SHORT
            ).show()
        }
        mBluetoothSwitch.setOnCheckedChangeListener { compoundButton, _ ->
            val switch_text = if(compoundButton.isChecked) "打开蓝牙" else "关闭蓝牙"
            Toast.makeText(
                this,
                switch_text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
