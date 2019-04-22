package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class MyBaseAdapter(private val mContext: Context, private val mDatas: List<Data>, private val mResId: Int) : BaseAdapter() {

    // 获得列表项的数量
    override fun getCount(): Int {
        return mDatas.size
    }

    // 获得当前列表项
    override fun getItem(position: Int): Data? {
        return mDatas[position]
    }

    // 获得当前列表项的ID
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 获得第position处的列表项组件
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
        // 获取LayoutInflater对象
        val inflater = LayoutInflater.from(mContext)
        // 装载列表项视图
        val itemView = inflater.inflate(mResId, null)

        // 获取列表项组件
        val iconImg = itemView.findViewById(R.id.icon_img) as ImageView
        val titleTv = itemView.findViewById(R.id.title_tv) as TextView
        val infoTv = itemView.findViewById(R.id.info_tv) as TextView

        // 给列表项赋值
        val data = getItem(position)
        if (null != data) {
            iconImg.setImageResource(data.icon)
            titleTv.text = data.title
            infoTv.text = data.info
        }

        return itemView
    }
}