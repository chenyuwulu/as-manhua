package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_2.*
import kotlinx.android.synthetic.main.course_44.*


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
                Toast.makeText(this, "帐号或密码为空", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(
                    this,
                    "用户名：" + mNameEt.text + "\n密码：" + mPasswordEt.text,
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        val message = intent.getStringExtra("data")
        if(message=="Activity"){//如果是通过activity打开的话
            this.activity_back_btn.visibility = View.VISIBLE
            this.activity_back_close_btn.visibility = View.VISIBLE
            this.activity_close_btn.visibility = View.VISIBLE
            this.activity_back_btn.setOnClickListener {
                // 获取启动当前Activity的上一个Intent
                val intent = Intent(this, Course_43::class.java)
                // 启动intent对应的Activity
                startActivity(intent)
            }
            this.activity_back_close_btn.setOnClickListener {
                // 获取启动当前Activity的上一个Intent
                val intent = Intent(this, Course_43::class.java)
                // 启动intent对应的Activity
                startActivity(intent)
                // 结束当前Activity
                finish()
            }
            this.activity_close_btn.setOnClickListener {
                // 结束当前Activity
                finish()
            }
        }
        val comp = intent.component
        this.intent_Component_text.text = "组件包名为：${comp!!.packageName}组件类名为：${comp.className}".trimIndent()
        this.intent_Action_text.text = "Action为：" + intent.action
        this.intent_Category_text.text = "Action为：" + intent.action + "\nCategory属性为：" + intent.categories
    }
}
