package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_43.*

class Course_43 :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_43)
        title = "Activity相关"
        this.start_button.setOnClickListener {
            val intent = Intent(this, Course_2::class.java)
            intent.putExtra("data", "Activity")
            startActivity(intent)
        }
        this.close_button.setOnClickListener {
            this.finish()
        }

    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // 获取更改后的屏幕方向
        val screen = newConfig.orientation
        val ori = if (Configuration.ORIENTATION_LANDSCAPE === screen) "横屏" else "竖屏"

        // 消息提示
        Toast.makeText(this, "系统的屏幕方向改变为：$ori", Toast.LENGTH_SHORT).show()
    }
}