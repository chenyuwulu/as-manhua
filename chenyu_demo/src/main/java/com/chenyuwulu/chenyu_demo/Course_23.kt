package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_23.*

class Course_23 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_23)
        title = "卡片堆叠展示"
        val mImageIds = intArrayOf(
            R.drawable.bh3_11,
            R.drawable.bh3_12,
            R.drawable.bh3_13,
            R.drawable.bh3_14,
            R.drawable.bh3_15,
            R.drawable.bh3_16,
            R.drawable.bh3_17,
            R.drawable.bh3_18
        )
        // 为AdapterViewFlipper设置Adapter
        val adapter = Course_23_MyStackAdapter(this, mImageIds)
        this.stackview.adapter = adapter
        this.prev_btn.setOnClickListener{
            this.stackview.showPrevious()
        }
        this.next_btn.setOnClickListener{
            this.stackview.showNext()
        }
    }
}
