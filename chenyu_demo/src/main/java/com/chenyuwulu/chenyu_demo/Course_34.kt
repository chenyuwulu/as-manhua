package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_34.*

class Course_34 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_34)
        title = "日历和定时器"
        val mChronometer = findViewById<Chronometer>(R.id.chronometer)

        mChronometer.format = "计时：%s"

        this.chronnmeter_start.setOnClickListener {
            mChronometer.start()
        }
        this.chronnmeter_stop.setOnClickListener {
            mChronometer.stop()
        }
        this.chronnmeter_reset.setOnClickListener {
            mChronometer.base = SystemClock.elapsedRealtime()
        }
    }
}