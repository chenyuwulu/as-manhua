package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class Course_17_MyArrayAdapter(context: Activity, private val mResourceId: Int, private val mItems: Array<String>) : ArrayAdapter<Any>(context, mResourceId, mItems) {
    private var mContext: Activity? = null

    init {
        mContext = context
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 获取LayoutInflater对象
        val inflater = mContext!!.layoutInflater
        // 装载列表项视图
        val itemView = inflater.inflate(mResourceId, null)

        // 获取列表项之组件
        val contentTv = itemView.findViewById(R.id.content_tv) as TextView
        val letterImg = itemView.findViewById(R.id.letter_img) as ImageView

        // 取出要显示的数据
        val content = mItems[position].trim { it <= ' ' }

        // 给TextView设置显示值
        contentTv.text = content
        // 根据内容首字母判断要显示的图标
        if (content.startsWith("a") || content.startsWith("A")) {
            letterImg.setImageResource(R.drawable.bh3_1)
        } else if (content.startsWith("b") || content.startsWith("B")) {
            letterImg.setImageResource(R.drawable.bh3_2)
        } else if (content.startsWith("c") || content.startsWith("C")) {
            letterImg.setImageResource(R.drawable.bh3_3)
        } else if (content.startsWith("d") || content.startsWith("D")) {
            letterImg.setImageResource(R.drawable.bh3_4)
        } else if (content.startsWith("e") || content.startsWith("E")) {
            letterImg.setImageResource(R.drawable.bh3_5)
        }

        // 返回列表项视图
        return itemView
    }
}