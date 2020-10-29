package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_32.*

class Course_32 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_32)
        title = "数值选择器"

        val mNumberPicker = this.numberPicker
        // 设置NumberPicker属性
        mNumberPicker.minValue = 1
        mNumberPicker.maxValue = 20
        mNumberPicker.value = 5
        // 监听数值改变事件
        mNumberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            Toast.makeText(this, "选择的是：" + newVal, Toast.LENGTH_SHORT).show()
        }
    }
}