package com.chenyuwulu.chenyu_demo

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.util.Printer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_16.*

class Course_16 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_16)
        title = "Android事件展示"

        this.button.setOnClickListener {
            Toast.makeText(this, "收到了点击事件", Toast.LENGTH_SHORT).show()
        }
        this.button1.setOnClickListener(BtnClickListener())
    }

    // 定义一个内部类,实现View.OnClickListener接口,并重写onClick()方法
    internal class BtnClickListener :View.OnClickListener{
        override fun onClick(view: View) {
            Log.w("11","1")
//            Toast.makeText(this, "wenzi",Toast.LENGTH_SHORT)
        }
    }
}
