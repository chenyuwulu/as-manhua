package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ZoomButton
import android.widget.ZoomControls
import androidx.appcompat.app.AppCompatActivity

class Course_6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_6)
        title = "图片按钮展示"
        val mControlIb = findViewById<ImageButton>(R.id.control_ib)
        var mFlag = false
        val mMinusZb = findViewById<ZoomButton>(R.id.minus_zb)
        val mPlusZb = findViewById<ZoomButton>(R.id.plus_zb)
        val mControlZc = findViewById<ZoomControls>(R.id.control_zc)
        mControlIb.setOnClickListener { // 根据记录的控制状态进行图标切换
            if (mFlag) {
                Toast.makeText(this, "暂停", Toast.LENGTH_SHORT).show()
                mControlIb.setImageResource(R.drawable.bh3_2)
                mFlag = false
            } else {
                Toast.makeText(this, "快进", Toast.LENGTH_SHORT).show()
                mControlIb.setImageResource(R.drawable.bh3_3)
                mFlag = true
            }
        }
        // 为缩小按钮绑定OnClickListener监听器
        mMinusZb.setOnClickListener { Toast.makeText(this, "缩小", Toast.LENGTH_SHORT).show() }
        // 为放大按钮绑定OnClickListener监听器
        mPlusZb.setOnClickListener { Toast.makeText(this, "放大", Toast.LENGTH_SHORT).show() }
        // 为缩放组件绑定OnZoomInClickListener监听器
        mControlZc.setOnClickListener {
            Toast.makeText(this, "放大", Toast.LENGTH_SHORT).show()
        }
        // 为缩放组件绑定OnZoomOutClickListener监听器
        mControlZc.setOnClickListener {
            Toast.makeText(this, "缩小", Toast.LENGTH_SHORT).show()
        }
    }
}
