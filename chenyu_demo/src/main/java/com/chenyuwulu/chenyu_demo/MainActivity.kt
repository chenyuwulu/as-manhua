package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "首页-网格布局" // 应用名
        val mAppNames = arrayListOf(
            "文本框","编辑框","按钮","单选和复选","开关按钮","图片","图片按钮",
            "自定义View","线性布局","布局重心","内外边距","相对布局","表格布局",
            "帧布局","绝对布局","网格布局","Android事件"
        )
        // 获取界面组件
        val mAppGridView = findViewById<GridView>(R.id.gridview)
        // 初始化数据，创建一个List对象，List对象的元素是Map
        val listItems = ArrayList<Map<String, Any>>()
        for (i in mAppNames) {
            val listItem = HashMap<String, Any>()
            val fanAnimaPicID = resources.getIdentifier(
//                "bh3_$i", "drawable",
                "logo","drawable",
                "com.chenyuwulu.chenyu_demo"
            )
            listItem["icon"] = fanAnimaPicID
            listItem["name"] = "$i"
            listItems.add(listItem)
        }
        // 创建一个SimpleAdapter
        val simpleAdapter = SimpleAdapter(
            this,
            listItems,
            R.layout.activity_main_item,
            arrayOf("icon", "name"),
            intArrayOf(R.id.icon_img, R.id.name_tv)
        )
        // 为GridView设置Adapter
        mAppGridView.adapter = simpleAdapter
        mAppGridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            //打开对应的activity
            startActivity(Intent(this,Class.forName("com.chenyuwulu.chenyu_demo.Course_$position")))
//            // 显示被单击的图片
//            Toast.makeText(
//                this, mAppNames[position],
//                Toast.LENGTH_SHORT
//            ).show()
        }
    }
}
