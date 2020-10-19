package com.chenyuwulu.chenyu_demo

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView


class Course_0 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_0)
        title = "TextView展示页面"

    }
//    自定义的textview
    class MyTextView : AppCompatTextView {
        constructor(context: Context?) : super(context!!) {}
        constructor(context: Context?, attrs: AttributeSet?) : super(
            context!!, attrs
        ) {
        }

        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
            context!!, attrs, defStyleAttr
        ) {
        }

        override fun isFocused(): Boolean {  //此方法直接返回true
            return true
        }
    }
}
