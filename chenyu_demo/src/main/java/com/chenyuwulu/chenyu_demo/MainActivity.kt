package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "首页-网格布局" // 应用名
        val mAppNames = arrayListOf(
            "文本框","编辑框","按钮","单选和复选","开关按钮","图片","图片按钮",//0-6
            "自定义View","线性布局","布局重心","内外边距","相对布局","表格布局", "帧布局",//7-13
            "绝对布局","网格布局","Android事件","listview","GridView","下拉框Spinner",//14-19
            "自动完成文本框","可折叠列表","图片轮播","卡片堆叠","进度条","拖动条星级评分",//20-25
            "视图切换","图片切换","文本切换","翻转视图","日期选择器","时间选择器",//26-31
            "数值选择器","时钟","日历和定时器","滚动视图","搜索框","选项卡","回收视图",//32-38
            "快速实现引导页","TabHost","CardView","下拉刷新","Activity","intent",
            "Activity传递数据","Activity回传数据","数据传递方法汇总","Fragment"
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
//            if(position==18){
//                startActivity(Intent(this,Class.forName("com.chenyuwulu.chenyu_demo.we_sub.qq_login")))
//            } else {
                startActivity(Intent(this,Class.forName("com.chenyuwulu.chenyu_demo.Course_$position")))
//            }

//            // 显示被单击的图片
//            Toast.makeText(
//                this, "这是第 $position 个",
//                Toast.LENGTH_SHORT
//            ).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("这里触发了", "onStart()")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("这里触发了", "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("这里触发了", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("这里触发了", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("这里触发了", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("这里触发了", "onDestroy()")
    }
}
