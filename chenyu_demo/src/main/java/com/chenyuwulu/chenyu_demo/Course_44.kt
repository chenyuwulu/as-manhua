package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_44.*


class Course_44 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_44)
        title = "intent"
        this.intent_Component.setOnClickListener {
            val intent = Intent(this, Course_2::class.java)
            startActivity(intent)
        }
        this.intent_Action.setOnClickListener {
            // 创建Intent对象
            val intent = Intent()
            intent.action = "com.chenyuwulu.chenyu_demo.intent_action"
            startActivity(intent)
        }
        this.intent_Category.setOnClickListener {
            val intent = Intent()
            intent.action = "com.chenyuwulu.chenyu_demo.intent_action"
            intent.addCategory("com.chenyuwulu.chenyu_demo.intent_category")
            startActivity(intent)
        }

        this.intent_data_fugai_type.setOnClickListener {
            val intent = Intent()
            intent.type = "abc/xyz"
            intent.data = Uri.parse("scheme://host:port/path")
            Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show()
        }
        this.intent_type_fugai_data.setOnClickListener {
            val intent = Intent()
            intent.data = Uri.parse("scheme://host:port/path")
            intent.type = "abc/xyz"
            Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show()
        }
        this.intent_data_and_type.setOnClickListener {
            val intent = Intent()
            intent.setDataAndType(Uri.parse("scheme://host:port/path"), "abc/xyz")
            Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show()
        }
    }
}