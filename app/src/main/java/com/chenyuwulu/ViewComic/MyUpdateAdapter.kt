package com.chenyuwulu.ViewComic

import android.widget.TextView
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.BaseAdapter
import android.widget.ImageView
import java.util.*


class MyUpdateAdapter : BaseAdapter {
    private var mContext: Context? = null
    private var mUpdateData: MutableList<UpdateData>? = null

    constructor() {}
    constructor(context: Context, UpdateDatas: MutableList<UpdateData>) {
        this.mUpdateData = UpdateDatas
        this.mContext = context
    }

    /**
     * 添加列表项
     * @param position
     * @param UpdateData
     */
    fun add(position: Int, UpdateData: UpdateData) {
        if (null == mUpdateData) {
            mUpdateData = LinkedList()
        }
        mUpdateData!!.add(position, UpdateData)
        notifyDataSetChanged()
    }

    /**
     * 更新列表内容
     * @param UpdateDatas
     */
    fun update(UpdateDatas: List<UpdateData>) {
        if (null == mUpdateData) {
            mUpdateData = LinkedList()
        }
        mUpdateData!!.clear()
        mUpdateData!!.addAll(UpdateDatas)

        notifyDataSetChanged()
    }

    /**
     * 更新列表项
     * @param position
     * @param UpdateData
     */
    fun update(position: Int, UpdateData: UpdateData) {
        if (mUpdateData != null && position < mUpdateData!!.size) {
            mUpdateData!![position] = UpdateData
        }
        notifyDataSetChanged()
    }

    /**
     * 移除指定列表项
     * @param position
     */
    fun remove(position: Int) {
        if (mUpdateData != null && 0 != count) {
            mUpdateData!!.removeAt(position)
        }
        notifyDataSetChanged()
    }

    /**
     * 清空列表数据
     */
    fun clear() {
        if (mUpdateData != null) {
            mUpdateData!!.clear()
        }
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mUpdateData!!.size
    }

    override fun getItem(position: Int): UpdateData {
        return mUpdateData!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.we_sub_listview_apply_item, null)
            holder = ViewHolder()
            holder.img_icon = convertView!!.findViewById(R.id.icon_img) as ImageView
            holder.txt_content = convertView!!.findViewById(R.id.content_tv)
            convertView!!.setTag(holder)
        } else {
            holder = convertView!!.getTag() as ViewHolder?
        }

        val UpdateData = getItem(position)
        holder!!.img_icon!!.setImageResource(UpdateData.imgId)
        holder.txt_content!!.text = UpdateData.content
        return convertView
    }

    private inner class ViewHolder {
        internal var img_icon: ImageView? = null
        internal var txt_content: TextView? = null
    }
}