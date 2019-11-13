package com.chenyuwulu.ViewComic

import android.annotation.SuppressLint
import android.widget.TextView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View


@SuppressLint("Registered")
class we_sub_activity_transmit_second : AppCompatActivity() {
    private var mNameTv: TextView? = null
    private var mPasswordTv: TextView? = null
    private var mSexTv: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.we_sub_activity_transmit_result)

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