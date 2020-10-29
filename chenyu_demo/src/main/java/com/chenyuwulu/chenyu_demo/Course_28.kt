package com.chenyuwulu.chenyu_demo

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_28.*

class Course_28 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_28)
        title = "文本切换"

        val mContents = arrayOf("你好", "HelloWorld", "Good!!!", "TextSwitcher", "你会了吗？")
        var mIndex: Int = 0
        this.textSwitcher.setFactory {
            val tv = TextView(this)
            tv.textSize = 40f
            tv.setTextColor(Color.MAGENTA)
            tv
        }
        this.textSwitcher.setOnClickListener { this.textSwitcher.setText(mContents[mIndex++ % mContents.size]) }
        this.textSwitcher.setText(mContents[0])
    }
}