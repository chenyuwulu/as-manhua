package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Course_31 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_31)
        title = "时间选择器"
        //获取日历对象
        val mCalendar = Calendar.getInstance()

        // 获取对应的时、分的信息
        val mHour = mCalendar.get(Calendar.HOUR_OF_DAY)
        val mMinute = mCalendar.get(Calendar.MINUTE)

        // 获取TimePicker组件
        val mTimePicker =findViewById<TimePicker>(R.id.timePicker)
        // 为TimePicker指定监听器
        mTimePicker!!.setOnTimeChangedListener { view, hourOfDay, minute ->
            Toast.makeText(this, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
        }
    }
}