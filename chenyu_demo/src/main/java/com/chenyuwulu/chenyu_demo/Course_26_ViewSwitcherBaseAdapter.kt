package com.chenyuwulu.chenyu_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Course_26_ViewSwitcherBaseAdapter(context: Context, itemDatas: List<Course_26_ViewSwitcherItemData>) : BaseAdapter() {
    private var mContext: Context? = null
    private var mItemDatas: List<Course_26_ViewSwitcherItemData>? = null

    init {
        this.mContext = context
        this.mItemDatas = itemDatas
    }

    override fun getCount(): Int {
        // 如果已经到了最后一屏，且应用程序的数量不能整除NUMBER_PER_SCREEN
        return if (Course_26.ViewSwitchers.screenNo === Course_26.ViewSwitchers.screenCount - 1 && mItemDatas!!.size % Course_26.ViewSwitchers.NUMBER_PER_SCREEN !== 0) {
            // 最后一屏显示的程序数为应用程序的数量对NUMBER_PER_SCREEN求余
            mItemDatas!!.size % Course_26.ViewSwitchers.NUMBER_PER_SCREEN
        } else Course_26.ViewSwitchers.NUMBER_PER_SCREEN
        // 否则每屏显示的程序数量为NUMBER_PER_SCREEN
    }

    override fun getItem(position: Int): Course_26_ViewSwitcherItemData {
        // 根据screenNo计算第position个列表项的数据
        return mItemDatas!![Course_26.ViewSwitchers.screenNo * Course_26.ViewSwitchers.NUMBER_PER_SCREEN + position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var cts = convertView
        val holder: ViewHolder?
        if (null == cts) {
            // 加载R.layout.item布局文件
            cts = LayoutInflater.from(mContext).inflate(R.layout.course_26_slide_gridview_item, null)
            holder = ViewHolder()
            holder.iconImg = cts!!.findViewById(R.id.icon_img) as ImageView
            holder.nameTv = cts.findViewById(R.id.name_tv)
            cts.setTag(holder)
        } else {
            holder = cts.getTag() as ViewHolder?
        }

        if (holder != null) {
            holder.iconImg!!.setImageResource(getItem(position).icon)
        }
        if (holder != null) {
            holder.nameTv!!.text = getItem(position).name
        }
        return cts
    }

    private inner class ViewHolder {
        internal var iconImg: ImageView? = null
        internal var nameTv: TextView? = null
    }
}