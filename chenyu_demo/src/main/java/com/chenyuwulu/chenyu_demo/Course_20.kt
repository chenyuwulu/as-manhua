package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class Course_20 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_20)
        title = "自动完成文本框展示"

        val mContacts = arrayOf("test", "abc", "aaa", "aabbcc", "bac", "ok", "say", "aabbsd")
        val mAutoTv = findViewById<AutoCompleteTextView>(R.id.auto_actv)
        val mMultiAutoTv = findViewById<MultiAutoCompleteTextView>(R.id.mauto_mactv)
        // 创建一个ArrayAdapter，封装数组
        val aa = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, mContacts
        )
        mAutoTv.setAdapter(aa)
        mMultiAutoTv.setAdapter(aa)
        mMultiAutoTv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}
