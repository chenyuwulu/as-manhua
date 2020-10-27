package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Course_21 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_21)
        title = "可折叠列表展示"
        // 列表数据
        var mGroupNameList: List<String>? = null
        var mItemNameList: List<List<String>>? = null
        // 适配器
        var mAdapter: Course_21_MyExpandableListViewAdapter? = null
        val mExpandableListView = findViewById<ExpandableListView>(R.id.expendlist)
        mExpandableListView.setGroupIndicator(null)

        //初始化数据
        // 组名
        mGroupNameList = ArrayList<String>()
        mGroupNameList.add("历代帝王")
        mGroupNameList.add("华坛明星")
        mGroupNameList.add("国外明星")
        mGroupNameList.add("政坛人物")

        mItemNameList = ArrayList<List<String>>()
        // 历代帝王组
        var itemList: MutableList<String> = ArrayList()
        itemList.add("唐太宗李世民")
        itemList.add("秦始皇嬴政")
        itemList.add("汉武帝刘彻")
        itemList.add("明太祖朱元璋")
        itemList.add("宋太祖赵匡胤")
        mItemNameList.add(itemList)
        // 华坛明星组
        itemList = ArrayList()
        itemList.add("范冰冰 ")
        itemList.add("梁朝伟")
        itemList.add("谢霆锋")
        itemList.add("章子怡")
        itemList.add("杨颖")
        itemList.add("张柏芝")
        mItemNameList.add(itemList)
        // 国外明星组
        itemList = ArrayList()
        itemList.add("安吉丽娜•朱莉")
        itemList.add("艾玛•沃特森")
        itemList.add("朱迪•福斯特")
        mItemNameList.add(itemList)
        // 政坛人物组
        itemList = ArrayList()
        itemList.add("唐纳德•特朗普")
        itemList.add("金正恩")
        itemList.add("奥巴马")
        itemList.add("普京")
        mItemNameList.add(itemList)
        // 为ExpandableListView设置Adapter
        mAdapter = Course_21_MyExpandableListViewAdapter(this, mGroupNameList, mItemNameList)
        mExpandableListView.setAdapter(mAdapter)

        // 监听组点击
        mExpandableListView.setOnGroupClickListener { parent, v, groupPosition, id ->
            mGroupNameList[groupPosition].isEmpty()
        }
        // 监听每个分组里子控件的点击事件
        mExpandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                this,
                mAdapter.getGroup(groupPosition) + ":" + mAdapter.getChild(groupPosition, childPosition),
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    }
}
