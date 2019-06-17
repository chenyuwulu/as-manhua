package com.example.myapplication

import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class ViewSwitcherBaseAdapter(context: Context, itemDatas: List<ViewSwitcherItemData>) : BaseAdapter() {
    private var mContext: Context? = null
    private var mItemDatas: List<ViewSwitcherItemData>? = null

    init {
        this.mContext = context
        this.mItemDatas = itemDatas
    }

    override fun getCount(): Int {
        // 如果已经到了最后一屏，且应用程序的数量不能整除NUMBER_PER_SCREEN
        return if (we_sub.ViewSwitchers.screenNo === we_sub.ViewSwitchers.screenCount - 1 && mItemDatas!!.size % we_sub.ViewSwitchers.NUMBER_PER_SCREEN !== 0) {
            // 最后一屏显示的程序数为应用程序的数量对NUMBER_PER_SCREEN求余
            mItemDatas!!.size % we_sub.ViewSwitchers.NUMBER_PER_SCREEN
        } else we_sub.ViewSwitchers.NUMBER_PER_SCREEN
        // 否则每屏显示的程序数量为NUMBER_PER_SCREEN
    }

    override fun getItem(position: Int): ViewSwitcherItemData {
        // 根据screenNo计算第position个列表项的数据
        return mItemDatas!![we_sub.ViewSwitchers.screenNo * we_sub.ViewSwitchers.NUMBER_PER_SCREEN + position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null
        if (null == convertView) {
            // 加载R.layout.item布局文件
            convertView = LayoutInflater.from(mContext).inflate(R.layout.we_sub_viewswitcher_slide_gridview_item, null)
            holder = ViewHolder()
            holder.iconImg = convertView!!.findViewById(R.id.icon_img) as ImageView
            holder.nameTv = convertView!!.findViewById(R.id.name_tv)
            convertView!!.setTag(holder)
        } else {
            holder = convertView!!.getTag() as ViewHolder?
        }

        if (holder != null) {
            holder.iconImg!!.setImageResource(getItem(position).icon)
        }
        if (holder != null) {
            holder.nameTv!!.text = getItem(position).name
        }
        return convertView
    }

    private inner class ViewHolder {
        internal var iconImg: ImageView? = null
        internal var nameTv: TextView? = null
    }
}