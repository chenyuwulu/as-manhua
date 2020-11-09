package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Course_45_transmit : AppCompatActivity() {
    private var mNameTv: TextView? = null
    private var mPasswordTv: TextView? = null
    private var mSexTv: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_45_result)

        val intent = intent
        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("password")
        val sex = intent.getStringExtra("sex")

        mNameTv = findViewById<View>(R.id.name_tv) as TextView?
        mPasswordTv = findViewById<View>(R.id.password_tv) as TextView?
        mSexTv = findViewById<View>(R.id.sex_tv) as TextView?

        mNameTv!!.text = "用户名：$name"
        mPasswordTv!!.text = "密    码：$password"
        mSexTv!!.text = "性    别：$sex"
    }
}