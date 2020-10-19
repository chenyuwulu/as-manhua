package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Course_3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_3)
        title = "单选按钮和复选按钮展示页"
        val mShanghaiCb = findViewById<CheckBox>(R.id.shanghai_cb)
        val mBeijingCb = findViewById<CheckBox>(R.id.beijing_cb)
        val mChongqingCb = findViewById<CheckBox>(R.id.chongqing_cb)
        val mMaleRb = findViewById<RadioButton>(R.id.male_rb)
        val mFemaleRb = findViewById<RadioButton>(R.id.female_rb)
        val mSexRg = findViewById<RadioGroup>(R.id.sex_rg)
        fun showSelectCity(compoundButton: CompoundButton) {
            val city = compoundButton.text.toString()
            val text = if (compoundButton.isChecked) "选中$city" else "取消选中$city"
            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }
        mShanghaiCb.setOnCheckedChangeListener { compoundButton, _ ->
            // 提示用户选择的城市
            showSelectCity(compoundButton)
        }
        mBeijingCb.setOnCheckedChangeListener { compoundButton, _ ->
            // 提示用户选择的城市
            showSelectCity(compoundButton)
        }
        mChongqingCb.setOnCheckedChangeListener { compoundButton, _ ->
            // 提示用户选择的城市
            showSelectCity(compoundButton)
        }
        mSexRg.setOnCheckedChangeListener { _, checkedId ->
            // 获取用户选中的性别
            var sex = ""
            when (checkedId) {
                R.id.male_rb -> sex = mMaleRb.text.toString()
                R.id.female_rb -> sex = mFemaleRb.text.toString()
                else -> {}
            }
            // 消息提示
            Toast.makeText(
                this,
                "选择的性别是：$sex",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
