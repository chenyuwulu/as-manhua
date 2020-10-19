package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Course_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_2)
        title = "Button展示页"
        val mNameEt = findViewById<EditText>(R.id.name_et)
        val mPasswordEt = findViewById<EditText>(R.id.pwd_et)
        val mLoginBtn = findViewById<Button>(R.id.login_btn)
        mLoginBtn.setOnClickListener{
            if(TextUtils.isEmpty(mNameEt.text) || TextUtils.isEmpty(mPasswordEt.text)){
                Toast.makeText(this,"帐号或密码为空", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"用户名：" + mNameEt.text + "\n密码：" + mPasswordEt.text, Toast.LENGTH_SHORT).show()
            }

        }
    }
}
