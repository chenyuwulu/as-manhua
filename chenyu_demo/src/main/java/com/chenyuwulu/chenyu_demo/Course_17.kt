package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_17.*

class Course_17 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_17)
        title = "listview展示"


        // 定义一个adapter数组
        val books = arrayOf(
            "初识Android开发", "Android初级开发", "Android中级开发",
            "Android高级开发", "Android开发进阶", "Android项目实战",
            "Android企业级开发"
        )
        // 将数组包装成ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, books)
        // 为ListView设置Adapter
        this.listview_adapter.adapter = adapter
        // 为ListView绑定列表项点击事件监听器
        this.listview_adapter.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "点击了" + books[position], Toast.LENGTH_SHORT).show()
        }


        // 定义一个List集合,list_activity
        val components = arrayListOf(
            "TextView", "EditText", "Button", "CheckBox",
            "RadioButton", "ToggleButton", "ImageView"
        )
        // 将List包装成ArrayAdapter
        val adapter_listview_activity = ArrayAdapter(this, R.layout.course_17_activity_custom, R.id.content_tv, components)

        // 为ListView设置Adapter
        this.listview_activity.adapter = adapter_listview_activity

        // 为ListView列表项绑定点击事件监听器
        this.listview_activity.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, components.get(position), Toast.LENGTH_SHORT).show()
        }


        // 自定义数组adapter
        val contents = arrayOf("Android", "demo", "Edit", "APP", "excel", "dota", "Button", "Circle", "excel", "back")

        // 将数组包装为自定义Course_17_MyArrayAdapter
        val ArrayAdapter = Course_17_MyArrayAdapter(this, R.layout.course_17_array_adapter_custom, contents)

        // 为ListView设置Adapter
        this.array_adapter.adapter = ArrayAdapter

    }
}
