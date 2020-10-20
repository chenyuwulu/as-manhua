package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_16.*


class Course_16 : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_16)
        title = "Android事件展示"

        this.button.setOnClickListener {
            Toast.makeText(this, "收到了点击事件", Toast.LENGTH_SHORT).show()
        }
        this.button1.setOnClickListener(BtnClickListener)
        this.mybutton.setOnTouchListener(OnTouchListener { _, _ ->
            Toast.makeText(
                this,
                "Activity收到onTouch事件监听", Toast.LENGTH_SHORT
            ).show()
            // 返回false，表明该事件会继续向外扩散
            false
        })
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        // 消息提示
        Toast.makeText(
            this,
            "Activity回调onTouchEvent方法", Toast.LENGTH_SHORT
        ).show()
        // 返回false，表明未完成处理该事件，该事件会继续向外扩散
        return false
    }
    private val BtnClickListener = View.OnClickListener {
        Toast.makeText(this, "外部私有", Toast.LENGTH_SHORT).show()
    }
    fun clickHandler(source: View?) {
        // 实现事件处理
        Toast.makeText(this, "直接绑定方法", Toast.LENGTH_SHORT).show()
    }



}