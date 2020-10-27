package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Course_19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_19)
        title = "下拉框Spinner展示"
        // 获取界面布局文件中的Spinner组件
        val mProSpinner = findViewById<Spinner>(R.id.spin_one)
        val mBookSpinner = findViewById<Spinner>(R.id.spin_two)

        val arr = arrayOf("初识Android开发", "Android初识开发", "Android中级开发", "Android高级开发", "Android开发进阶")
        // 创建ArrayAdapter对象
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, arr
        )
        // 为Spinner设置Adapter
        mBookSpinner.adapter = adapter
        // 为Spinner设置选中事件监听器
//                mProSpinner.onItemSelectedListener = this
        mBookSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val content = parent!!.getItemAtPosition(position).toString()
                when (parent.id) {
                    R.id.spin_one -> Toast.makeText(
                        this@Course_19, "选择的专业是：$content",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.spin_two -> Toast.makeText(
                        this@Course_19, "选择的教材是：$content",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> {
                    }
                }
            }

        }
        mProSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val content = parent!!.getItemAtPosition(position).toString()
                when (parent.id) {
                    R.id.spin_one -> Toast.makeText(
                        this@Course_19, "选择的专业是：$content",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.spin_two -> Toast.makeText(
                        this@Course_19, "选择的教材是：$content",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> {
                    }
                }
            }

        }
    }
}