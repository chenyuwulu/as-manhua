package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class Course_45 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_45)
        title = "数据传递"
        val mNameEt = findViewById<EditText>(R.id.name_et)
        val mPasswordEt = findViewById<EditText>(R.id.password_et)
        val mRegisterBtn = findViewById<Button>(R.id.register_btn)
        val mMaleRb = findViewById<RadioButton>(R.id.male_rb)
        val mFemaleRb = findViewById<RadioButton>(R.id.female_rb)

        mRegisterBtn.setOnClickListener {
            val intent = Intent(this, Course_45_transmit::class.java)
            intent.putExtra("name",mNameEt.text.toString().trim())
            intent.putExtra("password",mPasswordEt.text.toString().trim())
            var str = ""
            if(mMaleRb.isChecked){
                str = "男"
            }else if(mFemaleRb.isChecked){
                str = "女"
            }
            intent.putExtra("sex", str)
            startActivity(intent)
        }
    }
}