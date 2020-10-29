package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_30.*
import java.util.*

class Course_30 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_30)
        title = "日期选择器"

        //获取日历对象
        val mCalendar = Calendar.getInstance()
        // 获取当前对应的年、月、日的信息
        val mYear = mCalendar.get(Calendar.YEAR)
        val mMonth = mCalendar.get(Calendar.MONTH)
        val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
        // 获取DatePicker组件
        this.datePicker.init(mYear, mMonth, mDay) { _, year, monthOfYear, dayOfMonth ->
            Toast.makeText(this, year.toString() + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show()
        }
    }
}