package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.*
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


        // 自定义simpleadapter
        fun simpleadapter_getData(): List<Map<String, Any>> {
            val list = ArrayList<Map<String, Any>>()
            var map: MutableMap<String, Any> = HashMap()
            map["img"] = R.drawable.bh3_1
            map["title"] = "小宗"
            map["info"] = "电台DJ"
            list.add(map)

            map = HashMap()
            map["img"] = R.drawable.bh3_2
            map["title"] = "貂蝉"
            map["info"] = "四大美女"
            list.add(map)

            map = HashMap()
            map["img"] = R.drawable.bh3_3
            map["title"] = "奶茶"
            map["info"] = "清纯妹妹"
            list.add(map)

            map = HashMap()
            map["img"] = R.drawable.bh3_4
            map["title"] = "大黄"
            map["info"] = "是小狗"
            list.add(map)

            map = HashMap()
            map["img"] = R.drawable.bh3_5
            map["title"] = "hello"
            map["info"] = "every thing"
            list.add(map)

            map = HashMap()
            map["img"] = R.drawable.bh3_6
            map["title"] = "world"
            map["info"] = "hello world"
            list.add(map)

            return list
        }
        val simpleadapter = SimpleAdapter(this,
            simpleadapter_getData(),
            R.layout.course_17_simple_adapter,
            arrayOf("img", "title", "info"),
            intArrayOf(R.id.icon_img, R.id.title_tv, R.id.info_tv)
        )
        this.simple_adapter.adapter = simpleadapter

        // 自定义baseadapter
        fun baseadapter_getData(): List<Course_17_baseadapter_data> {
            val datas = ArrayList<Course_17_baseadapter_data>()
            datas.add(Course_17_baseadapter_data(R.drawable.bh3_1, "小宗", "电台DJ"))
            datas.add(Course_17_baseadapter_data(R.drawable.bh3_2, "貂蝉", "四大美女"))
            datas.add(Course_17_baseadapter_data(R.drawable.bh3_3, "奶茶", "清纯妹妹"))
            datas.add(Course_17_baseadapter_data(R.drawable.bh3_4, "大黄", "是小狗"))
            datas.add(Course_17_baseadapter_data(R.drawable.bh3_5, "hello", "every thing"))
            datas.add(Course_17_baseadapter_data(R.drawable.bh3_6, "world", "hello world"))
            return datas
        }

        // 将数组包装为自定义MyBaseAdapter
        val baseadapter = Course_17_baseadapter(this, baseadapter_getData(), R.layout.course_17_base_adapter)

        // 为ListView设置Adapter
        this.basea_adapter.adapter = baseadapter
    }
}
