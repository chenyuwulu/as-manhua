package com.chenyuwulu.chenyu_demo

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
        title = "首页-网格布局"
        // 应用名
        val mAppNames = arrayOf(
            "崩坏3-1",
            "崩坏3-2",
            "崩坏3-3",
            "崩坏3-4",
            "崩坏3-5",
            "崩坏3-6",
            "崩坏3-7",
            "崩坏3-8",
            "崩坏3-9",
            "崩坏3-1",
            "崩坏3-2",
            "崩坏3-3",
            "崩坏3-4",
            "崩坏3-5",
            "崩坏3-6",
            "崩坏3-7",
            "崩坏3-8",
            "崩坏3-9"
        )
        // 获取界面组件
        val mAppGridView = findViewById<GridView>(R.id.gridview)
        // 初始化数据，创建一个List对象，List对象的元素是Map
        val listItems = ArrayList<Map<String, Any>>()
        for (i in 1..35) {
            val listItem = HashMap<String, Any>()
            val fanAnimaPicID = resources.getIdentifier(
                "bh3_$i", "drawable",
                "com.chenyuwulu.chenyu_demo"
            )
            listItem["icon"] = fanAnimaPicID
            listItem["name"] = "崩坏3_$i"
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
            // 显示被单击的图片
            Toast.makeText(
                this, mAppNames[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
